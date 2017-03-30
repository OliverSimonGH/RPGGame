package com.oliver.main.Character.Players;

import com.oliver.main.Items.Armour.Armour;
import com.oliver.main.Items.Armour.ArmourID;
import com.oliver.main.Items.Weapons.Weapon;

/**
 * Created by c1633899 on 28/03/2017.
 */
public class PlayerEquipment {

    private Armour helmet;
    private Armour platebody;
    private Armour platelegs;
    private Weapon weapon;
    private Armour sheild;

    public PlayerEquipment(Armour helmet, Armour platebody, Armour platelegs, Weapon weapon, Armour sheild) {
        this.helmet = helmet;
        this.platebody = platebody;
        this.platelegs = platelegs;
        this.weapon = weapon;
        this.sheild = sheild;
    }

    public void giveEquipment(Armour p){
        if (p.getArmourID() == ArmourID.SteelHelmet){
            setHelmet(p);
        } else if(p.getArmourID() == ArmourID.SteelPlatebody){
            setPlatebody(p);
        } else if (p.getArmourID() == ArmourID.SteelPlatelegs){
            setPlatelegs(p);
        } else if (p.getArmourID() == ArmourID.SteelSheild){
            setSheild(p);
        }
    }

    public void showEquipment(Player p){
        PlayerEquipment e = p.getPlayerEquipment();
        if (e.getHelmet() != null){
            System.out.println("Helmet: " + e.getHelmet().getArmourID() + "(" + e.getHelmet().getEquipmentDefence() + " Defence)");
        }
        if (e.getPlatebody() != null){
            System.out.println("Platebody: " + e.getPlatebody().getArmourID() + "(" + e.getPlatebody().getEquipmentDefence() + " Defence)");
        }
        if (e.getPlatelegs() != null){
            System.out.println("Platelegs: " + e.getPlatelegs().getArmourID() + "(" + e.getPlatelegs().getEquipmentDefence() + " Defence)");
        }
        if (e.getSheild() != null){
            System.out.println("Sheild: " + e.getSheild().getArmourID() + "(" + e.getSheild().getEquipmentDefence() + " Defence)");
        }
        if (e.getWeapon() != null){
            System.out.println("Weapon: " + e.getWeapon().getWeaponID() + "(" + e.getWeapon().getMaxWeaponDamage() + "DMG)");
        }
        if (e.getHelmet() == null && e.getPlatebody() == null && e.getPlatelegs() == null && e.getSheild() == null && e.getWeapon() == null){
            System.out.println("You have nothing equipped.");
        }
        System.out.println();
    }

    public Armour getHelmet() {
        return helmet;
    }

    public void setHelmet(Armour helmet) {
        this.helmet = helmet;
    }

    public Armour getPlatebody() {
        return platebody;
    }

    public void setPlatebody(Armour platebody) {
        this.platebody = platebody;
    }

    public Armour getPlatelegs() {
        return platelegs;
    }

    public void setPlatelegs(Armour platelegs) {
        this.platelegs = platelegs;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getSheild() {
        return sheild;
    }

    public void setSheild(Armour sheild) {
        this.sheild = sheild;
    }
}
