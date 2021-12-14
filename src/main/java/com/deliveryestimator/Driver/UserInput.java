package com.deliveryestimator.Driver;

public class UserInput {

    private int orderId;
    private String[] meals;
    private float distance;

    public UserInput(int orderId, String[] meals, float distance) {
        this.orderId = orderId;
        this.meals = meals;
        this.distance = distance;
    }

    public int getOrderId() {
        return orderId;
    }

    public String[] getMeal() {
        return meals;
    }

    public float getDistance() {
        return distance;
    }
}
