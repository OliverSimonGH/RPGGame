package com.oliver.main.Character;

import com.oliver.main.Map.Rooms;
import com.oliver.main.Weapons.Weapon;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Player extends Person {

    private Weapon weapon;
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
    private Object[] inventory;

    public Player(String name, Weapon weapon, PersonID personId, int healthPoints, int minimumDamage, int maximumDamage, int energyPoints) {
        super(name, personId, healthPoints, minimumDamage, maximumDamage);
        this.weapon = weapon;
        this.energyPoints = energyPoints;
        this. x = 0;
        this.y = 0;
    }

    public int attackDamage(){
        //http://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        //generate a hit between the minimum and maximum damage;
        int playerHit = new Random().nextInt(getMaximumDamage() - getMinimumDamage() + 1) + getMinimumDamage();
        //get damage from weapon and generate a number hit from the player and weapon damage combined

        if (getWeapon() == null){
            return playerHit;
        } else {
            int weaponHit = new Random().nextInt(weapon.getMaxWeaponDamage() - weapon.getMinWeaponDamage() + 1) + weapon.getMinWeaponDamage();
            return (playerHit + weaponHit);
        }
    }

    public void attackPerson(Person enemy) {
        int dmg = attackDamage();
        final int healthBeforeDmg = enemy.getCurrentHealthPoints();
        enemy.setCurrentHealthPoints(enemy.getCurrentHealthPoints() - dmg);

        System.out.println("\nThe enemy(" + healthBeforeDmg + "HP) stand before you. You courageously attack and hit the enemy for " + dmg + " damage.");
        if (enemy.getCurrentHealthPoints() == 0) {
            System.out.println("The " + enemy.getName() + "(" + enemy.getCurrentHealthPoints()+ "HP) collapsed in front of you, he has been defeated!\n");
        } else {
            System.out.println("The enemy gets hurt, his remaining health is " + enemy.getCurrentHealthPoints() + "\n");
        }
    }

    public void movePlayer(Vector<Rooms> r){
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
        for (Rooms room : r){
            if (x == room.getX() && y == room.getY()){
                room.getDescription();

                Scanner scan = new Scanner(System.in);
                String userInput = scan.nextLine();

                if (userInput.equalsIgnoreCase("q")){
                    getStatistics(room);
                } else if (userInput.equalsIgnoreCase("a") && room.getEnemy() != null){
                    fightWithOptions(room);
                } else if (userInput.equalsIgnoreCase("e") && room.getFood() != null){
                    eatFood(room);
                } else if (userInput.equalsIgnoreCase("w") && room.getWeapon() != null){
                    pickUpWeapon(room);
                } else if (userInput.equalsIgnoreCase("c")){
                    System.out.println();
                    return;
                }
            }
        }
        checkRoomPlayerIsIn(r);
    }

    private void getStatistics(Rooms room){
        System.out.println("Health: " + getCurrentHealthPoints());
        System.out.println("Energy: " + getEnergyPoints());
        System.out.println("Max hit: " + getMaximumDamage());
        if (getWeapon() != null){
            System.out.println("Weapon: " + getWeapon().getWeaponID() + "(" + getWeapon().getMinWeaponDamage() + "-" + getWeapon().getMaxWeaponDamage() + ")");
            System.out.println("Max Hit With Weapon: " + (getMaximumDamage() + getWeapon().getMaxWeaponDamage()));
        }
        System.out.println("Location (X/Y): " + getX() + ", " + getY());
        System.out.println("Current Room: " + room.getName() + "\n");
    }

    private void pickUpWeapon(Rooms room) {
        setWeapon(room.getWeapon());
        System.out.println("You have equipped the " + room.getWeapon().getWeaponID() + "\n");
        room.setWeapon(null);
    }

    private void fightWithOptions(Rooms room) {
        while (isAlive()){
            if (!room.getEnemy().isAlive()) {
                room.setEnemy(null);
                return;
            } else {
                System.out.println("\nPress A to attack the enemy");
                System.out.println("Press R to run away from the enemy, you coward!");

                Scanner scan = new Scanner(System.in);
                String option = scan.nextLine();

                if (option.equalsIgnoreCase("a")){
                    attackPerson(room.getEnemy());
                    if (!room.getEnemy().isAlive()) return;
                    room.getEnemy().attackPerson(this);
                }
                else if (option.equalsIgnoreCase("r")){
                    System.out.println();
                    return;
                }
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getEnergyPoints() {
        if (energyPoints < 0) energyPoints = 0;
        return energyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        this.energyPoints = energyPoints;
    }
}
