package com.oliver.main.Game;

import com.oliver.main.Character.Enemy;
import com.oliver.main.Character.PersonID;
import com.oliver.main.Character.Player;
import com.oliver.main.Food.Food;
import com.oliver.main.Food.FoodID;
import com.oliver.main.Map.Rooms;
import com.oliver.main.Weapons.Weapon;
import com.oliver.main.Weapons.WeaponID;

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
        Scanner scan = new Scanner(System.in);
        Game game = new Game();
        game.spawnObjects();
        Player playerOne = new Player("Oliver", null, PersonID.PLAYER, 100, 0, 20, 30);

        while(playerOne.isAlive()){
            playerOne.checkRoomPlayerIsIn(game.getRooms());
            playerOne.movePlayer(game.getRooms());

        }
    }

    private void spawnObjects() {
        enemy.add(new Enemy("Goku", PersonID.ENEMY, 70, 10, 30));
        enemy.add(new Enemy("Gohan", PersonID.ENEMY, 60, 7, 20));
        enemy.add(new Enemy("Goten", PersonID.ENEMY, 45, 5, 15));
        enemy.add(new Enemy("Chi-Chi", PersonID.ENEMY, 55, 2, 12));
        enemy.add(new Enemy("All-Chan", PersonID.ENEMY, 100, 0, 35));
        enemy.add(new Enemy("Beerus", PersonID.ENEMY, 80, 13, 25));
        enemy.add(new Enemy("Kaio-Sama", PersonID.ENEMY, 40, 10, 15));
        enemy.add(new Enemy("Broly", PersonID.ENEMY, 50, 0, 18));
        enemy.add(new Enemy("Trunks", PersonID.ENEMY, 45, 0, 14));
        weapons.add(new Weapon(WeaponID.Bat, 0, 3));
        weapons.add(new Weapon(WeaponID.Gun, 0, 10));
        weapons.add(new Weapon(WeaponID.Knife, 0, 5));
        weapons.add(new Weapon(WeaponID.Sword, 2, 7));
        food.add(new Food(FoodID.Potato, 10, 2));
        food.add(new Food(FoodID.Fish, 15, 3));
        food.add(new Food(FoodID.Chicken, 20, 4));
        food.add(new Food(FoodID.Lobster, 25, 5));
        food.add(new Food(FoodID.Pizza, 30, 6));
        rooms.add(new Rooms("Kitchen", 1, 0, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("Bathroom", 0, 1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("Bedroom", 1, 1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("Living Room", -1, 0, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("basement", -1, -1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("hallway", 0, -1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("attic", 1, 2, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("backyard", 2, 1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("Double Door room", 3, 1, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("Grave Yard", 2, 2, selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("Play House", -2, -1,selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
        rooms.add(new Rooms("Secret Room", -2, -2,selectRandomFood(), selectRandomEnemy(), selectRandomWeapon()));
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
        if (randomChance > 60) {
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
