package com.oliver.main.Character.Player;

import com.oliver.main.Character.Person;
import com.oliver.main.Character.PersonID;
import com.oliver.main.Map.Rooms;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Player extends Person {

    private int energyPoints;
    private int x;
    private int y;
    private boolean north = false;
    private boolean east = false;
    private boolean south = false;
    private boolean west = false;
    private String northRoom;
    private String eastRoom;
    private String southRoom;
    private String westRoom;
    private PlayerEquipment playerEquipment;
    private Inventory inventory;

    public Player(String name, PlayerEquipment playerEquipment, Inventory inventory, PersonID personId, int healthPoints, int minimumDamage, int maximumDamage, int energyPoints) {
        super(name, personId, healthPoints, minimumDamage, maximumDamage);
        this.inventory = inventory;
        this.playerEquipment = playerEquipment;
        this.energyPoints = energyPoints;
        this.x = 0;
        this.y = 0;
    }

    public int attackDamage(){
        //http://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        //generate a hit between the minimum and maximum damage;
        int playerHit = new Random().nextInt(getMaximumDamage() - getMinimumDamage() + 1) + getMinimumDamage();
        //get damage from weapon and generate a number hit from the player and weapon damage combined

        if (playerEquipment.getWeapon() == null){
            return playerHit;
        } else {
            int weaponHit = new Random().nextInt(playerEquipment.getWeapon().getMaxWeaponDamage() - playerEquipment.getWeapon().getMinWeaponDamage() + 1) + playerEquipment.getWeapon().getMinWeaponDamage();
            return (playerHit + weaponHit);
        }
    }

    public void attackPerson(Person enemy) {
        int dmg = attackDamage();
        final int healthBeforeDmg = enemy.getCurrentHealthPoints();
        enemy.setCurrentHealthPoints(enemy.getCurrentHealthPoints() - dmg);

        System.out.println("\nThe enemy(" + healthBeforeDmg + "HP) stand before you. You courageously attack and hit the enemy for " + dmg + " damage.");
        if (enemy.getCurrentHealthPoints() == 0) {
            System.out.println("The " + enemy.getName() + "(" + enemy.getCurrentHealthPoints()+ "HP) collapsed in front of you, the opponent been defeated!\n");
        } else {
            System.out.println("The enemy gets hurt, his remaining health is " + enemy.getCurrentHealthPoints() + "\n");
        }
    }

    public void movePlayer(Vector<Rooms> r){
        if (!isAlive()) {return;}
        for (Rooms room : r) {
            boolean northPossible = (x == room.getX()) && (y + 1 == room.getY());
            boolean southPossible = (x == room.getX()) && (y - 1 == room.getY());
            boolean eastPossible = (x + 1 == room.getX()) && (y == room.getY());
            boolean westPossible = (x - 1 == room.getX()) && (y == room.getY());

            if (northPossible) {
                north = true;
                northRoom = room.getName();
                System.out.println("Press: W to go to " + northRoom + " (North)");
            }
            if (southPossible) {
                south = true;
                southRoom = room.getName();
                System.out.println("Press: S to go to " + southRoom + " (South)");
            }
            if (eastPossible) {
                east = true;
                eastRoom = room.getName();
                System.out.println("Press: D to go to " + eastRoom + " (East)");
            }
            if (westPossible) {
                west = true;
                westRoom = room.getName();
                System.out.println("Press: A to go to " + westRoom + " (West)");
            }
        }

        Scanner scan = new Scanner(System.in);
        String direction = scan.nextLine();

        if (direction.equalsIgnoreCase("w") && north) {
            System.out.println("You have moved to the " + northRoom + "\n");
            energyPoints--;
            y++;
        } else if (direction.equalsIgnoreCase("s") && south) {
            System.out.println("You have moved to the " + southRoom + "\n");
            energyPoints--;
            y--;
        } else if (direction.equalsIgnoreCase("d") && east) {
            System.out.println("You have moved to the " + eastRoom + "\n");
            energyPoints--;
            x++;
        } else if (direction.equalsIgnoreCase("a") && west) {
            System.out.println("You have moved to the " + westRoom + "\n");
            energyPoints--;
            x--;
        } else {System.out.println("Please select a valid direction\n"); movePlayer(r);}

        north = false;
        east = false;
        west = false;
        south = false;
    }

    public void checkRoomPlayerIsIn(Vector<Rooms> r){
        if (!isAlive()){return;}
        for (Rooms room : r){
            if (x == room.getX() && y == room.getY()){
                room.getDescription();

                Scanner scan = new Scanner(System.in);
                String userInput = scan.nextLine();

                if (userInput.equalsIgnoreCase("1")){
                    getStatistics(room);
                } else if (userInput.equalsIgnoreCase("2")){
                    inventory.showInventory();
                } else if (userInput.equalsIgnoreCase("3")){
                    playerEquipment.showEquipment(this);
                } else if (userInput.equalsIgnoreCase("4") && room.getEnemy() != null){
                    fightWithOptions(room);
                } else if (userInput.equalsIgnoreCase("5") && room.getFood() != null){
                    eatFood(room);
                } else if (userInput.equalsIgnoreCase("6") && room.getWeapon() != null){
                    pickUpWeapon(room);
                } else if (userInput.equalsIgnoreCase("7") && room.getNpc() != null){
                    interactWithNpc(room);
                } else if (userInput.equalsIgnoreCase("8") && room.getItem() != null){
                    pinkUpTradable(room);
                } else if (userInput.equalsIgnoreCase("9")){
                    System.out.println();
                    return;
                }
            }
        }
        checkRoomPlayerIsIn(r);
    }

    private void pinkUpTradable(Rooms room) {
        inventory.addItemToInventory(room.getItem());
        System.out.println("You have added " + room.getItem().getTradeableID() + " to your inventory\n");
        room.setItem(null);
    }

    private void interactWithNpc(Rooms room){
        System.out.println("\nPress 1 to talk to " + room.getNpc().getName());
        System.out.println("Press 2 to give " + room.getNpc().getName() + " the required item");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.equalsIgnoreCase("1")){
            System.out.println(room.getNpc().getQuestion() + " I will reward you with " + room.getNpc().getGiftItem().getArmourID());
            interactWithNpc(room);
        } else if (input.equalsIgnoreCase("2")){
            for (int i = 0; i < inventory.inventorySize(); i++) {
                if (room.getNpc().getRequiredItem() == inventory.getInventoryItem(i)){
                    System.out.println("You have given " + inventory.getInventoryItem(i).getTradeableID() + " to " + room.getNpc().getName());
                    inventory.removeInventoryItem(i);
                    System.out.println(room.getNpc().getName() + " has placed " + room.getNpc().getGiftItem().getArmourID() + " in your equipment");
                    System.out.println(room.getNpc().getName() + " now disappers\n");
                    playerEquipment.giveEquipment(room.getNpc().getGiftItem());
                    room.setNpc(null);
                }
            } if (room.getNpc() != null){
                System.out.println("The required item was not in your inventory, find the item and come back\n");
            }
        }
    }

    private void getStatistics(Rooms room){
        System.out.println("Health: " + getCurrentHealthPoints());
        System.out.println("Energy: " + getEnergyPoints());
        System.out.println("Max hit: " + getMaximumDamage());
        if (playerEquipment.getWeapon() != null){
            System.out.println("Weapon: " + playerEquipment.getWeapon().getWeaponID() + "(" + playerEquipment.getWeapon().getMinWeaponDamage() + "-" + playerEquipment.getWeapon().getMaxWeaponDamage() + ")");
            System.out.println("Max Hit With Weapon: " + (getMaximumDamage() + playerEquipment.getWeapon().getMaxWeaponDamage()));
        }
        System.out.println("Location (X/Y): " + getX() + ", " + getY());
        System.out.println("Current Room: " + room.getName() + "\n");
    }

    private void pickUpWeapon(Rooms room) {
        playerEquipment.setWeapon(room.getWeapon());
        System.out.println("You have equipped the " + room.getWeapon().getWeaponID() + "\n");
        room.setWeapon(null);
    }

    private void fightWithOptions(Rooms room) {
        while (isAlive()){
            System.out.println("\nPress A to attack the enemy");
            System.out.println("Press R to run away from the enemy, you coward!");

            Scanner scan = new Scanner(System.in);
            String option = scan.nextLine();

            if (option.equalsIgnoreCase("a")){
                attackPerson(room.getEnemy());
                if (!room.getEnemy().isAlive()) {room.setEnemy(null); return;}
                room.getEnemy().attackPerson(this);
            }
            else if (option.equalsIgnoreCase("r")){
                System.out.println();
                return;
            }
        }
    }

    private void eatFood(Rooms room){
        int health = getCurrentHealthPoints();
        int energy = getEnergyPoints();
        setCurrentHealthPoints(health += room.getFood().getHealthHeal());
        setEnergyPoints(energy += room.getFood().getEnergyHeal());
        System.out.println("You have eaten the " + room.getFood().getFoodID() + ", Health: " + getCurrentHealthPoints() +  ", Energy: " + getEnergyPoints() + "\n");
        room.setFood(null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getEnergyPoints() {
        if (energyPoints < 0) energyPoints = 0;
        return energyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        this.energyPoints = energyPoints;
    }

    public PlayerEquipment getPlayerEquipment() {
        return playerEquipment;
    }

    public void setPlayerEquipment(PlayerEquipment playerEquipment) {
        this.playerEquipment = playerEquipment;
    }
}
