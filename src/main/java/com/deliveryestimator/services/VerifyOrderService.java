package com.deliveryestimator.services;

import com.deliveryestimator.models.Meal;
import com.deliveryestimator.models.Order;
import com.deliveryestimator.models.Restaurant;

import java.util.Map;

public class VerifyOrderService {

    public static int calculateNumStovesRequired(Order order)
    {
        int numStoves = 0;
        for (Map.Entry<String, Integer> entry: order.getItemQtyMapping().entrySet())
        {
            Meal appetizer = AddDishToMenuService.getDishMapping().get(entry.getKey());
            int appetizerQty = order.getItemQtyMapping().get(entry.getKey());
            numStoves += appetizer.getNumStovesRequired() * appetizerQty ;
        }

        return numStoves;
    }
    public static boolean takeOrder(Restaurant restaurant, Order order) {

        int numStovesRequired = calculateNumStovesRequired(order);
        if(order.getDeliveryTime() > 150.0 || numStovesRequired > restaurant.getCookingSlotsPanel().getNumStoves()){
            return false;
        }

        return true;

    }
}
