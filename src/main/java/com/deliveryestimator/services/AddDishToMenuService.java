package com.deliveryestimator.services;

import com.deliveryestimator.models.Meal;

import java.util.HashMap;

// This class adds a dish to the menu.
public class AddDishToMenuService {

    private static HashMap<String, Meal> dishMapping = new HashMap<>();

    public static HashMap<String, Meal> getDishMapping() {
        return dishMapping;
    }

    public static void addDish(Meal dish)
    {
        dishMapping.put(dish.getMealType(), dish);
    }
}
