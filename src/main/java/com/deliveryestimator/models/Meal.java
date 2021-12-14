package com.deliveryestimator.models;

public class Meal {

    private String mealType;
    private int cookingTime;
    private int numStovesRequired;

    public String getMealType() {
        return mealType;
    }

    public int getNumStovesRequired() {
        return numStovesRequired;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public Meal(String appetizerType, int cookingTime, int numStovesRequired) {
        this.mealType = appetizerType;
        this.cookingTime = cookingTime;
        this.numStovesRequired = numStovesRequired;
    }
}
