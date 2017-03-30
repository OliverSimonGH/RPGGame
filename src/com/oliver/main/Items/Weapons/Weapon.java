package com.oliver.main.Items.Weapons;

import com.oliver.main.Items.Item;
import com.oliver.main.Items.ItemID;

/**
 * Created by c1633899 on 21/02/2017.
 */
public class Weapon extends Item {

    private WeaponID weaponID;
    private int minWeaponDamage;
    private int maxWeaponDamage;

    public Weapon(ItemID itemid, WeaponID weaponID, int minWeaponDamage, int maxWeaponDamage) {
        super(itemid);
        this.weaponID = weaponID;
        this.minWeaponDamage = minWeaponDamage;
        this.maxWeaponDamage = maxWeaponDamage;
    }

    public WeaponID getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(WeaponID weaponID) {
        this.weaponID = weaponID;
    }

    public int getMinWeaponDamage() {
        return minWeaponDamage;
    }

    public void setMinWeaponDamage(int minWeaponDamage) {
        this.minWeaponDamage = minWeaponDamage;
    }

    public int getMaxWeaponDamage() {
        return maxWeaponDamage;
    }

    public void setMaxWeaponDamage(int maxWeaponDamage) {
        this.maxWeaponDamage = maxWeaponDamage;
    }
}
