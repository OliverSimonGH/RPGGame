package com.oliver.main.Character.Npc;

import com.oliver.main.Items.Armour.Armour;
import com.oliver.main.Items.Item;

/**
 * Created by c1633899 on 28/03/2017.
 */
public class Npc {

    private String name;
    private String question;
    private Item requiredItem;
    private Armour giftItem;

    public Npc(String name, String question, Item requiredItem, Armour giftItem) {
        this.name = name;
        this.question = question;
        this.requiredItem = requiredItem;
        this.giftItem = giftItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(Item requiredItem) {
        this.requiredItem = requiredItem;
    }

    public Armour getGiftItem() {
        return giftItem;
    }

    public void setGiftItem(Armour giftItem) {
        this.giftItem = giftItem;
    }
}
