package com.oliver.main.Items;

/**
 * Created by c1633899 on 28/03/2017.
 */
public class Item {

    private ItemID itemid;

    public Item(ItemID itemid) {
        this.itemid = itemid;
    }

    public ItemID getItemid() {
        return itemid;
    }

    public void setItemid(ItemID itemid) {
        this.itemid = itemid;
    }
}
