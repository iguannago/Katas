package com.nutrition.dto;

public enum SortField {
    CALORIES("calories"),
    NAME("name");

    private final String fieldName;

    SortField(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return fieldName;
    }
}
