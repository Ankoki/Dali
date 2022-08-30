# DALI  

DALI is a generic till system base, calculating stock based on ingredient amount. This was inspired by me being fed up with the inefficiency of the system Mitchell & Butlers use.  

If being cloned, it is recommended to delete the contents of `com.ankoki.dali.impl` and add your own dishes/ingredients. Example implementation can be seen in the source. Remember to also clear the declared dishes in `com.ankoki.dali.helpers.StorageCache`.  

### Example JSON  

You can find an example of what the storage.json should look like in `resources`. Under the `stock-count` map, you will find the layout to be `"ingredient-key": amount in grams`.

### Usage  

Registering ingredients is simple. Any ingredients that are not found in the storage cache will be added automatically with an amount of 0.  
```java
import com.ankoki.dali.api.Ingredient;

public class NewPotatoes extends Ingredient {

    public NewPotatoes(int quantity) {
        super(quantity); // This constructor is used when specifying how many portions go into a dish.
    }

    @Override
    public int getPortionSize() {
        return 500; // This signifies each portion will be 500 grams.
    }

    @Override
    public double getPrice() {
        return 2.00; // I use 0.00 just for readability, as this signifies £2.00
    }

    @NotNull
    @Override
    public String getId() {
        return "New Potatoes"; // The ID which is used in the storage. Must be unique. This is also used on the interface as the name.
    }
    
}
```  

Registering dishes is just as simple, as these are not stored directly, you will just need to register what ingredients are used, like so.  
```java
import com.ankoki.dali.api.Dish;

public class SteakPieMain extends Dish {

    public SteakPie() {
        super(new SteakPie(1),
                new Mash(1),
                new SeasonalGreens(1),
                new Gravy(1));
    }

    @Override
    public double getPrice() {
        return 12.00;
    }

    @NotNull
    @Override
    public String getId() {
        return "Steak and Ale Pie";
    }
}
```  
You do have the option of registering ingredients when initiating the `dishes` array in `com.ankoki.dali.helpers.StorageCache` using the Dish constructor, however I personally find it easier to declare it in the child class itself. 
### Third-Party Libraries  

[Argo](https://www.github.com/Moderocky/Argo) by Moderocky - Used for JSON parsing.