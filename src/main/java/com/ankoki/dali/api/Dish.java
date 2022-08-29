package com.ankoki.dali.api;

public abstract class Dish implements Stock {

    private final Ingredient[] ingredients;

    public Dish(Ingredient... ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Gets the ingredients of the dish.
     * @return the ingredients of the dish.
     */
    public Ingredient[] getIngredients() {
        return ingredients;
    }
}
