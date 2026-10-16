package com.nutrition.model;

public record Food(
    String name,
    Integer calories,
    Double totalFat,
    FatRating fatRating,
    String caffeine
) {
    public enum FatRating {
        LOW,
        MEDIUM,
        HIGH
    }
}
