package com.deliveryestimator.models;

import java.util.HashMap;

public class Order {

    private int orderId;
    private HashMap<String, Integer> itemQtyMapping;
    private float deliveryDistance;
    private int totalItems;
    private float deliveryTime;

    public Order(int orderId, HashMap<String, Integer> itemQtyMapping, int totalItems, float deliveryDistance) {
        this.orderId = orderId;
        this.itemQtyMapping = itemQtyMapping;
        this.deliveryDistance = deliveryDistance;
        this.totalItems = totalItems;
    }

    public HashMap<String, Integer> getItemQtyMapping() {
        return itemQtyMapping;
    }

    public void setItemQtyMapping(HashMap<String, Integer> itemQtyMapping) {
        this.itemQtyMapping = itemQtyMapping;
    }

    public int getOrderId() {
        return orderId;
    }

    public float getDeliveryTime() {
        return deliveryTime;
    }

    public float getDeliveryDistance() {
        return deliveryDistance;
    }

    public void setDeliveryTime(float deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}
