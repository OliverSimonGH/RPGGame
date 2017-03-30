package com.oliver.main.Map;

import com.oliver.main.Character.Enemys.Enemy;
import com.oliver.main.Character.Npcs.Npc;
import com.oliver.main.Items.Food.Food;
import com.oliver.main.Items.Tradeable.Tradeable;
import com.oliver.main.Items.Weapons.Weapon;

public class Rooms {
    private String name;
    private Food food;
    private int x;
    private int y;
    private Enemy enemy;
    private Weapon weapon;
    private Npc npc;
    private Tradeable item;

    public Rooms(String name, int x, int y, Food food, Enemy enemy, Weapon weapon) {
        this.name = name;
        this.food = food;
        this.x = x;
        this.y = y;
        this.enemy = enemy;
        this.weapon = weapon;
    }

    public Rooms(String name, int x, int y, Food food, Enemy enemy, Weapon weapon, Tradeable item) {
        this.item = item;
        this.name = name;
        this.food = food;
        this.x = x;
        this.y = y;
        this.enemy = enemy;
        this.weapon = weapon;
    }

    public Rooms(String name, int x, int y, Food food, Enemy enemy, Weapon weapon, Npc npc) {
        this.npc = npc;
        this.name = name;
        this.food = food;
        this.x = x;
        this.y = y;
        this.enemy = enemy;
        this.weapon = weapon;
    }


    public Rooms(String name, int x, int y, Food food, Enemy enemy, Weapon weapon, Tradeable item, Npc npc) {
        this.item = item;
        this.npc = npc;
        this.name = name;
        this.food = food;
        this.x = x;
        this.y = y;
        this.enemy = enemy;
        this.weapon = weapon;
    }


    public void getDescription() {
        System.out.println("Press 1 to get your players statistics");
        System.out.println("Press 2 to show your Inventory");
        System.out.println("Press 3 to show your Equipment");
        if (enemy != null){
            System.out.println("There is an enemy within the room, it's a " + enemy.getName() + ". Press 4 to fight with the enemy");
        }
        if (food != null){
            System.out.println("You have found a " + food.getFoodID()+ " in the room, press 5 to eat the food");
        }
        if (weapon != null){
            System.out.println("You have found a " + weapon.getWeaponID() + "(" + weapon.getMaxWeaponDamage()+ "DMG) in the room, Press 6 to pick it up");
        }
        if (npc != null){
            System.out.println("There is an npc called " + npc.getName() + " in the room, press 7 to talk to him");
        }
        if (item != null){
            System.out.println("You have found a " + item.getTradeableID()+ " in the room, press 8 to pickup the item");
        }
        if (enemy == null && food == null && weapon == null){
            System.out.println("This room is empty, your adventure must carry on");
        }
        System.out.println("Press 9 to escape the room.");
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

    public Npc getNpc() {
        return npc;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }

    public Tradeable getItem() {
        return item;
    }

    public void setItem(Tradeable item) {
        this.item = item;
    }
}
