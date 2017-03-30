package com.oliver.main.Character.Enemy;

import com.oliver.main.Character.Person;
import com.oliver.main.Character.PersonID;

import java.util.Random;

/**
 * Created by c1633899 on 21/02/2017.
 */
public class Enemy extends Person {

    public Enemy(String name, PersonID personId, int maxHealthPoints, int minimumDamage, int maximumDamage) {
        super(name, personId, maxHealthPoints, minimumDamage, maximumDamage);
    }

    public int attackDamage(){
        //http://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        //generate a hit between the minimum and maximum damage;
        int enemyHit = new Random().nextInt(getMaximumDamage() - getMinimumDamage() + 1) + getMinimumDamage();

        return enemyHit;
        //chance to hit nothing;
    }

    @Override
    public void attackPerson(Person player) {
        int dmg = attackDamage();
        final int healthBeforeDmg = player.getCurrentHealthPoints();
        player.setCurrentHealthPoints(player.getCurrentHealthPoints() - dmg);

        System.out.println("The " + getName() + " attacks you(" + healthBeforeDmg + "HP) back, your health is reduced to: " + player.getCurrentHealthPoints());
        System.out.println("You step back and review your options before your next move");
    }
}
