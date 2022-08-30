package com.ankoki.dali.impl.ingredients;

import com.ankoki.dali.api.Ingredient;
import org.jetbrains.annotations.NotNull;

public class Gravy extends Ingredient {

    public Gravy(int quantity) {
        super(quantity);
    }

    @Override
    public int getPortionSize() {
        return 100;
    }

    @Override
    public double getPrice() {
        return 0.00;
    }

    @NotNull
    @Override
    public String getId() {
        return "Gravy";
    }
}
