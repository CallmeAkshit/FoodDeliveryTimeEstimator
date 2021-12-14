package com.deliveryestimator.services;

import com.deliveryestimator.models.Meal;

public class SetDishService {

    public static Meal setDish(String dishType, int cookingTime, int numSlotsRequired)
    {
        Meal dish = new Meal(dishType, cookingTime,numSlotsRequired);
        return dish;
    }
}
