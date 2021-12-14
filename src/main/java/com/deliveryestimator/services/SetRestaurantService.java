package com.deliveryestimator.services;

import com.deliveryestimator.models.CookingSlot;
import com.deliveryestimator.models.Restaurant;

public class SetRestaurantService {

    public static Restaurant setRestaurant(int restaurantID, int numCookingSlots, int deliveryTimeTakenPerKm)
    {
        Restaurant restaurant = new Restaurant(restaurantID, new CookingSlot(numCookingSlots),deliveryTimeTakenPerKm);
        return restaurant;
    }
}
