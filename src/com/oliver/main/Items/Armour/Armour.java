package com.oliver.main.Items.Armour;

import com.oliver.main.Items.Item;
import com.oliver.main.Items.ItemID;

/**
 * Created by c1633899 on 28/03/2017.
 */
public class Armour extends Item {

    private ArmourID armourID;
    private int equipmentDefence;
    private int equipmentWeight;

    public Armour(ItemID itemid, ArmourID armourID, int equipmentDefence, int equipmentWeight) {
        super(itemid);
        this.armourID = armourID;
        this.equipmentDefence = equipmentDefence;
        this.equipmentWeight = equipmentWeight;
    }

    public ArmourID getArmourID() {
        return armourID;
    }

    public void setArmourID(ArmourID armourID) {
        this.armourID = armourID;
    }

    public int getEquipmentDefence() {
        return equipmentDefence;
    }

    public void setEquipmentDefence(int equipmentDefence) {
        this.equipmentDefence = equipmentDefence;
    }

    public int getEquipmentWeight() {
        return equipmentWeight;
    }

    public void setEquipmentWeight(int equipmentWeight) {
        this.equipmentWeight = equipmentWeight;
    }
}
