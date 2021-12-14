package com.deliveryestimator.services;

import com.deliveryestimator.models.Order;
import com.deliveryestimator.models.Restaurant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class DeliveryTimeCalculatorService {

    public static float calculateWaitingTime(Restaurant restaurant, Order order, float nonWaitingTime)
    {
        float waitingTime = 0;
        Deque<Order> tempStack = new ArrayDeque<>();
        int numSlotsRequiredByOrder = VerifyOrderService.calculateNumStovesRequired(order);

        // if number of available slots are not sufficient then
        // waiting time for the order will keep getting
        // incremented by the total time taken by the dishes which got prepared earliest
        // till the slot requirement is accomplished.

        //A min stack is maintained which is a stack of orders, arranged such that
        // the order which takes minimum time will be at the top.

        if(numSlotsRequiredByOrder > restaurant.getNumSlotsAvailable())
        {
            int numSlotsAvailable = restaurant.getNumSlotsAvailable();

            while(restaurant.getMinTimeStack().size() != 0 &&
                    numSlotsAvailable < numSlotsRequiredByOrder)
            {
                Order lastOrder = restaurant.getMinTimeStack().pop();
                numSlotsAvailable += VerifyOrderService.calculateNumStovesRequired(lastOrder);
                restaurant.setNumSlotsAvailable(numSlotsAvailable);
                waitingTime += lastOrder.getDeliveryTime();
            }
        }

        int reducedAvailablePanels = restaurant.getNumSlotsAvailable() - numSlotsRequiredByOrder;
        restaurant.setNumSlotsAvailable(reducedAvailablePanels);


        // The new order will be pushed in the min stack
        while(restaurant.getMinTimeStack().size() != 0 && restaurant.getMinTimeStack().peek().getDeliveryTime() < nonWaitingTime)
        {
            Order tempOrder = restaurant.getMinTimeStack().pop();
            tempStack.push(tempOrder);
        }

        restaurant.getMinTimeStack().push(order);

        while(tempStack.size() != 0)
        {
            restaurant.getMinTimeStack().push(tempStack.pop());
        }
        return waitingTime;
    }
    public static void calculateTime(Restaurant restaurant, Order order)
    {
        //time to cook
        float maxCookingTime = 0;

        //time to deliver
        float deliveryTime = 0;

        //time to cook + delivery time
        float nonWaitingTime = 0;

        //waiting time (in case sufficient slots were not available)
        float waitingTime = 0;

        //waiting + non-waiting time
        float totalTime = 0;

        //cooking time will be equal maximum of all items' cooking time.
        for (Map.Entry<String, Integer> entry: order.getItemQtyMapping().entrySet())
        {
            int cookingTime = AddDishToMenuService.getDishMapping().get(entry.getKey()).getCookingTime();
            maxCookingTime = Math.max(maxCookingTime,cookingTime );
        }

        deliveryTime = order.getDeliveryDistance() * restaurant.getDeliveryTimeTakenPerKm();
        nonWaitingTime = maxCookingTime + deliveryTime;

        waitingTime = calculateWaitingTime(restaurant,order,nonWaitingTime);

        totalTime = maxCookingTime + deliveryTime + waitingTime;
        order.setDeliveryTime(totalTime);

    }
}
