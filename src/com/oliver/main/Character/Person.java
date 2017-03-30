package com.oliver.main.Character;

/**
 * Created by c1633899 on 21/02/2017.
 */
public abstract class Person {

    private String name;
    private PersonID personId;
    private int maxHealthPoints;
    private int currentHealthPoints;
    private boolean isAlive = true;
    private int minimumDamage;
    private int maximumDamage;

    public Person(String name, PersonID personId, int maxHealthPoints, int minimumDamage, int maximumDamage) {
        this.name = name;
        this.personId = personId;
        this.maxHealthPoints = maxHealthPoints;
        this.currentHealthPoints = maxHealthPoints;
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;
    }

    public abstract int attackDamage();
    public abstract void attackPerson(Person p);
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonID getPersonId() {
        return personId;
    }

    public void setPersonId(PersonID personId) {
        this.personId = personId;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getCurrentHealthPoints() {
        if (currentHealthPoints <= 0) {currentHealthPoints = 0; isAlive = false;}
        else if (currentHealthPoints >= 100) {currentHealthPoints = 100;}
        return currentHealthPoints;
    }

    public void setCurrentHealthPoints(int currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    public int getMinimumDamage() {
        return minimumDamage;
    }

    public void setMinimumDamage(int minimumDamage) {
        this.minimumDamage = minimumDamage;
    }

    public int getMaximumDamage() {
        return maximumDamage;
    }

    public void setMaximumDamage(int maximumDamage) {
        this.maximumDamage = maximumDamage;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
