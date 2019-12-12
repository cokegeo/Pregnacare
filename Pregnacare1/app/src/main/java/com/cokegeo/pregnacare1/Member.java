package com.cokegeo.pregnacare1;

import android.content.Intent;

/**
 * Created by Jorge Luis Orellana Espinoza - x15000061
 * Cokegeo
 **/
public class Member {
    private String FoodName;
    private Integer Calories;
    private Float Vitamins;

    public Member() {
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public Integer getCalories() {
        return Calories;
    }

    public void setCalories(Integer calories) {
        Calories = calories;
    }

    public Float getVitamins() {
        return Vitamins;
    }

    public void setVitamins(Float vitamins) {
        Vitamins = vitamins;
    }
}
