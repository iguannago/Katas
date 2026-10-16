package com.nutrition.dto;

public record Sort(
    SortField field,
    SortOrder order
) { }
