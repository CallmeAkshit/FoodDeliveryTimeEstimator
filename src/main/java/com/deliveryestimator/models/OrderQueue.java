package com.deliveryestimator.models;

import java.util.ArrayDeque;
import java.util.Deque;

public class OrderQueue {

    private Deque<Order> orderQueue ;

    public OrderQueue() {
        this.orderQueue = new ArrayDeque<>();
    }

    public Deque<Order> getOrderQueue() {
        return orderQueue;
    }
}
