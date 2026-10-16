package com.nutrition.dto;

import com.nutrition.model.Food.FatRating;

import java.util.List;

public interface NutritionSearchRequest {

    Integer minCalories();
    Integer maxCalories();
    List<Sort> sorts();
    FatRating fatRating();
    int limit();
}
