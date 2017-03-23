package com.oliver.main.Food;

/**
 * Created by c1633899 on 28/02/2017.
 */
public class Food {

    private FoodID foodID;
    private int heal;

    public Food(FoodID foodID, int heal) {
        this.foodID = foodID;
        this.heal = heal;
    }

    public FoodID getFoodID() {
        return foodID;
    }

    public void setFoodID(FoodID foodID) {
        this.foodID = foodID;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }
}
