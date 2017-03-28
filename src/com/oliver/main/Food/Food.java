package com.oliver.main.Food;

/**
 * Created by c1633899 on 28/02/2017.
 */
public class Food {

    private FoodID foodID;
    private int healthHeal;
    private int energyHeal;

    public Food(FoodID foodID, int healthHeal, int energyHeal) {
        this.foodID = foodID;
        this.healthHeal = healthHeal;
        this.energyHeal = energyHeal;
    }

    public FoodID getFoodID() {
        return foodID;
    }

    public void setFoodID(FoodID foodID) {
        this.foodID = foodID;
    }

    public int getHealthHeal() {
        return healthHeal;
    }

    public void setHealthHeal(int healthHeal) {
        this.healthHeal = healthHeal;
    }

    public int getEnergyHeal() {
        return energyHeal;
    }

    public void setEnergyHeal(int energyHeal) {
        this.energyHeal = energyHeal;
    }
}
