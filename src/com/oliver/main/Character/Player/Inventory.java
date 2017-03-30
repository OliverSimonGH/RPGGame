package com.oliver.main.Character.Player;

import com.oliver.main.Items.Item;
import com.oliver.main.Items.Tradeable.Tradeable;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by c1633899 on 28/03/2017.
 */
public class Inventory {

    private Vector<Tradeable> items = new Vector<>();

    public Inventory() {}

    public void addItemToInventory(Tradeable i){
        items.add(i);
    }

    public void showInventory(){
        if (items.size() == 0){
            System.out.println("Your Inventory is empty\n");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.println("Slot " + (i + 1) + ": " + items.get(i).getTradeableID());
            }
            System.out.println();
        }
    }

    public Tradeable getInventoryItem(int i){
        return items.get(i);
    }

    public void removeInventoryItem(int i){
        items.remove(i);
    }

    public int inventorySize(){
        return items.size();
    }
}
