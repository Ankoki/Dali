package com.ankoki.dali.api;

public abstract class Ingredient implements Stock {

    private int quantity;

    /**
     * Creates a new ingredient with a quantity (for dishes).
     * @param quantity the quantity of the ingredient.
     */
    public Ingredient(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the portion size in grams.
     * @return the portion size in grams.
     */
    public abstract int getPortionSize();

    /**
     * Gets the quantity of the current ingredient.
     * @return the quantity of the ingredient.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the current dish.
     * @param quantity the new quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
