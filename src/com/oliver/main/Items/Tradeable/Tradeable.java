package com.oliver.main.Items.Tradeable;

import com.oliver.main.Items.Item;
import com.oliver.main.Items.ItemID;

/**
 * Created by c1633899 on 28/03/2017.
 */
public class Tradeable extends Item {

    private String description;
    private TradeableID tradeableID;

    public Tradeable(ItemID itemid, TradeableID tradeableID, String description) {
        super(itemid);
        this.tradeableID = tradeableID;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TradeableID getTradeableID() {
        return tradeableID;
    }

    public void setTradeableID(TradeableID tradeableID) {
        this.tradeableID = tradeableID;
    }
}
