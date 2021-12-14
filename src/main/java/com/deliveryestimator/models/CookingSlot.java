package com.deliveryestimator.models;

public class CookingSlot {

    private int numStoves;

    public CookingSlot(int numStoves) {
        this.numStoves = numStoves;
    }

    public int getNumStoves() {
        return numStoves;
    }

    public void setNumStoves(int numStoves) {
        this.numStoves = numStoves;
    }
}
