package com.ankoki.dali.impl.ingredients;

import com.ankoki.dali.api.Ingredient;
import org.jetbrains.annotations.NotNull;

public class Mash extends Ingredient {

    public Mash(int quantity) {
        super(quantity);
    }

    @Override
    public int getPortionSize() {
        return 200;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @NotNull
    @Override
    public String getId() {
        return "mashed-potato";
    }
}
