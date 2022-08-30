package com.ankoki.dali.impl.ingredients;

import com.ankoki.dali.api.Ingredient;
import org.jetbrains.annotations.Nullable;

public class SteakPie extends Ingredient {

    public SteakPie(int quantity) {
        super(quantity);
    }

    @Override
    public int getPortionSize() {
        return 300;
    }

    @Override
    public double getPrice() {
        return -1;
    }

    @Nullable
    @Override
    public String getId() {
        return null;
    }
}
