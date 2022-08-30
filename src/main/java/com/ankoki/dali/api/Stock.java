package com.ankoki.dali.api;

import org.jetbrains.annotations.Nullable;

public interface Stock {

    /**
     * Gets the price of the stock in GBP.
     * <p/>
     * Return -1 if this product cannot be sold individually.
     * @return the price of the stock.
     */
    double getPrice();

    /**
     * Gets the ID for the stock. This is also used on the till as its button label.
     * @return the ID. Null if the item is a dish and cannot be sold individually.
     */
    @Nullable
    String getId();
}
