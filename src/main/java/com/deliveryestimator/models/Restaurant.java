package com.deliveryestimator.models;

import java.util.*;

public class Restaurant {

    private int restaurantID;
    private CookingSlot cookingSlotsPanel;
    private OrderQueue orderQueue;
    private Deque<Order> minTimeStack;
    private int numSlotsAvailable;
    private int deliveryTimeTakenPerKm;

    public Restaurant(int restaurantID, CookingSlot cookingSlotsPanel, int deliveryTimeTakenPerKm) {
        this.restaurantID = restaurantID;
        this.cookingSlotsPanel = cookingSlotsPanel;
        this.orderQueue = new OrderQueue();
        this.deliveryTimeTakenPerKm = deliveryTimeTakenPerKm;
        minTimeStack = new ArrayDeque<>();
        numSlotsAvailable = cookingSlotsPanel.getNumStoves();
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public CookingSlot getCookingSlotsPanel() {
        return cookingSlotsPanel;
    }

    public void setCookingSlotsPanel(CookingSlot cookingSlotsPanel) {
        this.cookingSlotsPanel = cookingSlotsPanel;
    }

    public Deque<Order> getOrderQueue() {
        return orderQueue.getOrderQueue();
    }

    public void setOrderQueue(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    public int getNumSlotsAvailable() {
        return numSlotsAvailable;
    }

    public void setNumSlotsAvailable(int numSlotsAvailable) {
        this.numSlotsAvailable = numSlotsAvailable;
    }

    public Deque<Order> getMinTimeStack() {
        return minTimeStack;
    }

    public void setMinTimeStack(Deque<Order> minTimeStack) {
        this.minTimeStack = minTimeStack;
    }

    public int getDeliveryTimeTakenPerKm() {
        return deliveryTimeTakenPerKm;
    }

    public void setDeliveryTimeTakenPerKm(int deliveryTimeTakenPerKm) {
        this.deliveryTimeTakenPerKm = deliveryTimeTakenPerKm;
    }
}
