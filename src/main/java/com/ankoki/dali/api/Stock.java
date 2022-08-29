package com.ankoki.dali.api;

import org.jetbrains.annotations.NotNull;

public interface Stock {

    /**
     * Gets the price of the stock in GBP.
     * <p/>
     * Return -1 if this product cannot be sold individually.
     * @return the price of the stock.
     */
    double getPrice();

    /**
     * Gets the ID for the stock.
     * @return the ID.
     */
    @NotNull
    String getId();
}
