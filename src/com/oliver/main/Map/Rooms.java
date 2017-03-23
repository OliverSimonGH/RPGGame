package com.oliver.main.Map;

import com.oliver.main.Character.Enemy;
import com.oliver.main.Character.Player;
import com.oliver.main.Food.Food;
import com.oliver.main.Weapons.Weapon;

import java.util.Vector;

public class Rooms {
    private String name;
    private Food food;
    private int x;
    private int y;
    private Enemy enemy;
    private Weapon weapon;

    public Rooms(String name, int x, int y, Food food, Enemy enemy, Weapon weapon) {
        this.name = name;
        this.food = food;
        this.x = x;
        this.y = y;
        this.enemy = enemy;
        this.weapon = weapon;
    }

    public void getDescription() {
        if (enemy.isAlive()){
            System.out.println("There is an enemy within the room, it's a " + enemy.getName() + ". Press A to fight with the enemy");
        }
        if (food != null){
            System.out.println("You have found a " + food.getFoodID()+ " in the room, press E to eat the food");
        }
        if (!enemy.isAlive() && food == null){
            System.out.println("This room is empty, your adventure must carry on");
        }
        System.out.println("Press C to escape the room.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
