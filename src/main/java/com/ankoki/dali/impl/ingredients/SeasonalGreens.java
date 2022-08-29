package com.ankoki.dali.impl.ingredients;

import com.ankoki.dali.api.Ingredient;
import org.jetbrains.annotations.NotNull;

public class SeasonalGreens extends Ingredient {

    public SeasonalGreens(int quantity) {
        super(quantity);
    }

    @Override
    public int getPortionSize() {
        return 150;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @NotNull
    @Override
    public String getId() {
        return "seasonal-greens";
    }
}
