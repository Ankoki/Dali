package com.ankoki.dali.helpers;

import com.ankoki.dali.api.Dish;
import com.ankoki.dali.api.Ingredient;
import com.ankoki.dali.impl.ingredients.Gravy;
import com.ankoki.dali.impl.ingredients.Mash;
import com.ankoki.dali.impl.ingredients.SeasonalGreens;
import mx.kenzie.argo.Json;
import mx.kenzie.argo.meta.JsonException;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StorageCache {

    private static StorageCache instance;

    /**
     * Initiates the cache from a json file.
     * @param file
     */
    public static void initiate(File file) {
        if (!file.getName().endsWith(".json")) throw new IllegalArgumentException("You must initiate cache from a JSON file.");
        instance = new StorageCache(file);
    }

    public static StorageCache getInstance() {
        return instance;
    }

    private final File storageFile;
    private final Map<String, Object> CACHE = new HashMap<>();
    private final Ingredient[] ingredients;
    private final Dish[] dishes;

    protected StorageCache(File file) {
        storageFile = file;
        try (final Json json = new Json(new FileInputStream(file))) {
            CACHE.putAll(json.toMap());
        } catch (JsonException | IOException ex) {
            System.err.println("There was an issue when parsing the JSON file. Full stacktrace shown below.\n");
            ex.printStackTrace();
            System.err.println("\nPlease report this to whoever applicable. Application will now close.");
            System.exit(0);
        }

        ingredient_declaration: {
            ingredients = new Ingredient[]{
                    new Gravy(0),
                    new Mash(0),
                    new SeasonalGreens(0)
            };
        }

        dishes_declaration: {
            dishes = new Dish[]{

            };
        }
    }

    /**
     * Returns whether a dish is in stock.
     * @param dish the dish to check.
     * @return true if the dish is in stock, else false.
     */
    public boolean inStock(Dish dish) {
        for (Ingredient ingredient : dish.getIngredients()) {
            if (!this.inStock(ingredient)) return false;
        } return true;
    }

    /**
     * Returns whether an ingredient is in stock.
     * @param ingredient the ingredient to check.
     * @return true if the ingredient is in stock, else false.
     */
    public boolean inStock(Ingredient ingredient) {
        Map<String, Integer> stock = (Map<String, Integer>) CACHE.get("stock-count");
        if (!stock.containsKey(ingredient.getId())) {
            stock.put(ingredient.getId(), 0);
            synchronized (CACHE) {
                CACHE.put("stock-count", stock);
            } return false;
        } else return stock.get(ingredient.getId()) >= ingredient.getPortionSize();
    }

    /**
     * Gets all the registered dishes.
     * @return the registered dishes.
     */
    public Dish[] getDishes() {
        return dishes;
    }

    /**
     * Gets all the registered ingredients.
     * @return the registered ingredients.
     */
    public Ingredient[] getIngredients() {
        return ingredients;
    }

    /**
     * Backs up the current cache into the file.
     * Called every 30 minutes by default.
     * @return whether backup has succeeded.
     */
    public boolean backupCache() {
        final String json = Json.toJson(CACHE, "  ");
        try {
            FileWriter fileWriter = new FileWriter(storageFile);
            try (final BufferedWriter writer = new BufferedWriter(fileWriter)) {
                writer.write(json);
            }
        } catch (IOException ex) {
            System.err.println("There was an error backing up the ingredient cache. Full stacktrace will be shown below.\n");
            ex.printStackTrace();
            System.err.println("\nPlease report this to whoever applicable. Any data updated may be lost.");
            return false;
        } return true;
    }

    /**
     * Gets the ingredient object from a key string.
     * @return the matching Ingredient, null if not found.
     */
    @Nullable
    private Ingredient getIngredient0(String key) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getId().equals(key)) return ingredient;
        } return null;
    }
}
