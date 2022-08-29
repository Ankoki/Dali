package com.ankoki.dali.impl.dishes.mains;

import com.ankoki.dali.api.Dish;
import com.ankoki.dali.impl.ingredients.Gravy;
import com.ankoki.dali.impl.ingredients.Mash;
import com.ankoki.dali.impl.ingredients.SeasonalGreens;
import org.jetbrains.annotations.NotNull;

public class SteakPie extends Dish {

    public SteakPie() {
        super(new com.ankoki.dali.impl.ingredients.SteakPie(1),
                new Mash(1),
                new SeasonalGreens(1),
                new Gravy(1));
    }

    @Override
    public double getPrice() {
        return 12;
    }

    @NotNull
    @Override
    public String getId() {
        return "steak-pie-dish";
    }
}
