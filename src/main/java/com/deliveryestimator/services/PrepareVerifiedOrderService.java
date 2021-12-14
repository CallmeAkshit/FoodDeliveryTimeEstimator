package com.deliveryestimator.services;

import com.deliveryestimator.models.Order;
import com.deliveryestimator.models.Restaurant;

public class PrepareVerifiedOrderService {

    static String orderAcceptance;
    static String orderRejection;
    static float waitTimeForNextOrder;

    public static void createOrder(Restaurant restaurant, Order order)
    {
        if(VerifyOrderService.takeOrder(restaurant, order) == true)
        {
            restaurant.getOrderQueue().offerLast(order);
            DeliveryTimeCalculatorService.calculateTime(restaurant,order);
            waitTimeForNextOrder += order.getDeliveryTime();
            System.out.println("Order " +  order.getOrderId() + " will get delivered in "+ order.getDeliveryTime() + " minutes");
            return;
        }

        orderRejection = "Order " +  order.getOrderId() + " is denied because the restaurant cannot accommodate it.";
        System.out.println(orderRejection);

    }

    public static float getWaitTimeForNextOrder() {
        return waitTimeForNextOrder;
    }
}
