package com.oliver.main.Game;

import com.oliver.main.Character.Enemys.Enemy;
import com.oliver.main.Character.Npcs.Npc;
import com.oliver.main.Character.Players.PlayerEquipment;
import com.oliver.main.Character.PersonID;
import com.oliver.main.Character.Players.Inventory;
import com.oliver.main.Character.Players.Player;
import com.oliver.main.Items.Armour.Armour;
import com.oliver.main.Items.Armour.ArmourID;
import com.oliver.main.Items.Food.Food;
import com.oliver.main.Items.Food.FoodID;
import com.oliver.main.Items.ItemID;
import com.oliver.main.Items.Tradeable.Tradeable;
import com.oliver.main.Items.Tradeable.TradeableID;
import com.oliver.main.Map.Rooms;
import com.oliver.main.Items.Weapons.Weapon;
import com.oliver.main.Items.Weapons.WeaponID;

import java.util.*;

/**
 * Created by c1633899 on 21/02/2017.
 */
public class Game {

    private Vector<Rooms> rooms = new Vector<>();
    private Vector<Weapon> weapons = new Vector<>();
    private Vector<Food> food = new Vector<>();
    private Vector<Enemy> enemy = new Vector<>();


    public static void main(String[] args) {
        boolean running = true;
        Game game = new Game();
        game.spawnObjects();
        Player playerOne = new Player("Oliver", new PlayerEquipment(null, null, null, null, null), new Inventory(), PersonID.PLAYER, 100, 0, 20, 30);

        System.out.println("Welcome to my RPG game");
        System.out.println("The rules are simple");
        System.out.println("1. Do not die or run out of energy");
        System.out.println("2. Kill all the enemies");
        System.out.println("3. Complete all NPC quests\n");

        System.out.println("Items, Enemies and Weapons randomly spawn, may the RNG gods be with you");
        System.out.println("You have started at the Entrance");
        System.out.println("Please enjoy! \n");

        while(running){
            playerOne.checkRoomPlayerIsIn(game.getRooms());
            playerOne.movePlayer(game.getRooms());
            if (!playerOne.isAlive() || playerOne.getEnergyPoints() <= 0){
                if (playerOne.getEnergyPoints() <=0){
                    System.out.println("You have run out of energy");
                }
                System.out.println("you fall to the ground and die, you played a good game.");
                running = false;
            }
        }
    }

    private void spawnObjects() {
        Tradeable lostTreasure = new Tradeable(ItemID.Tradeable, TradeableID.Lost_Treasure , "Maybe I should return this lost treasure");
        Tradeable Skull = new Tradeable(ItemID.Tradeable, TradeableID.Skull, "It's missing the body.");
        Tradeable Gem = new Tradeable(ItemID.Tradeable, TradeableID.Gem, "A very dissapointing small gem");
        Tradeable onePiece = new Tradeable(ItemID.Tradeable, TradeableID.One_Piece, "A lot of shiny things");
        enemy.add(new Enemy("Goku", PersonID.ENEMY, 70, 10, 30));
        enemy.add(new Enemy("Gohan", PersonID.ENEMY, 60, 7, 20));
        enemy.add(new Enemy("Goten", PersonID.ENEMY, 45, 5, 15));
        enemy.add(new Enemy("Chi-Chi", PersonID.ENEMY, 55, 2, 12));
        enemy.add(new Enemy("All-Chan", PersonID.ENEMY, 100, 0, 35));
        enemy.add(new Enemy("Beerus", PersonID.ENEMY, 80, 13, 25));
        enemy.add(new Enemy("Kaio-Sama", PersonID.ENEMY, 40, 10, 15));
        enemy.add(new Enemy("Broly", PersonID.ENEMY, 50, 0, 18));
        enemy.add(new Enemy("Trunks", PersonID.ENEMY, 45, 0, 14));
        weapons.add(new Weapon(ItemID.Weapon, WeaponID.Bat, 0, 3));
        weapons.add(new Weapon(ItemID.Weapon, WeaponID.Gun, 0, 10));
        weapons.add(new Weapon(ItemID.Weapon, WeaponID.Knife, 0, 5));
        weapons.add(new Weapon(ItemID.Weapon, WeaponID.Sword, 2, 7));
        food.add(new Food(ItemID.Food, FoodID.Potato, 10, 2));
        food.add(new Food(ItemID.Food, FoodID.Fish, 15, 3));
        food.add(new Food(ItemID.Food, FoodID.Chicken, 20, 4));
        food.add(new Food(ItemID.Food, FoodID.Lobster, 25, 5));
        food.add(new Food(ItemID.Food, FoodID.Pizza, 30, 6));
        rooms.add(new Rooms("Kitchen", 1, 0, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon(), Skull));
        rooms.add(new Rooms("Bathroom", 0, 1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("Bedroom", 1, 1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon(), new Npc("Bob", "Could you find me a shiny Gem?", Gem, new Armour(ItemID.Equipment, ArmourID.SteelPlatelegs, 30, 15))));
        rooms.add(new Rooms("Living Room", -1, 0, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("hallway", 0, -1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon(), new Npc("Thomas", "Could you find me a human without a body?", Skull, new Armour(ItemID.Equipment, ArmourID.SteelPlatebody, 45, 23))));
        rooms.add(new Rooms("attic", 1, 2, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon(), onePiece));
        rooms.add(new Rooms("basement", -1, -1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("backyard", 2, 1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon(),new Npc("Pirate", "Could you find my lost treasure?", lostTreasure, new Armour(ItemID.Equipment, ArmourID.SteelHelmet, 20, 10))));
        rooms.add(new Rooms("Double Door Room", 3, 1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("Grave Yard", 2, 2, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon(), Gem));
        rooms.add(new Rooms("Play House", -2, -1,selectRandomFood(), selectRandomEnemy(), selectRandomWeapon(), new Npc("Jim", "I have lost one piece, can you help me find it?", onePiece, new Armour(ItemID.Equipment, ArmourID.SteelSheild, 15, 5))));
        rooms.add(new Rooms("Secret Room", -2, -2,selectRandomFood(), selectRandomEnemy(), selectRandomWeapon(), lostTreasure));
        rooms.add(new Rooms("Play Ground", -3, -2, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("Entrance", 0, 0, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
    }

    private Weapon selectRandomWeapon() {
        int randomChance = new Random().nextInt(100) + 1;
        if (randomChance > 65) {
            int randWeapon = new Random().nextInt(weapons.size());
            return weapons.get(randWeapon);
        }
        return null;
    }

    private Enemy selectRandomEnemy() {
        int randomChance = new Random().nextInt(100) + 1;
        if (randomChance > 0) {
            int randEnemy = new Random().nextInt(enemy.size());
            return enemy.get(randEnemy);
        }
        return null;
    }

    private Food selectRandomFood() {
        int randomChance = new Random().nextInt(100) + 1;
        if (randomChance > 50) {
            int randFood = new Random().nextInt(food.size());
            return food.get(randFood);
        }
        return null;
    }

    public Vector<Rooms> getRooms() {
        return rooms;
    }

}
