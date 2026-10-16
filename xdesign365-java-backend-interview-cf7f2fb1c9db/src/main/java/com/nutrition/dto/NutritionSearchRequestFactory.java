package com.nutrition.dto;

import com.nutrition.model.Food;
import org.apache.commons.lang3.Validate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.apache.commons.lang3.StringUtils.isBlank;

public final class NutritionSearchRequestFactory {

    private NutritionSearchRequestFactory() { /* Non-instantiable class */ }

    public static NutritionSearchRequest newRequest(
        Integer minCalories,
        Integer maxCalories,
        List<String> sortParams,
        String fatRatingStr,
        int limit
    ) {
        Validate.isTrue(limit > 0, "Limit must be greater than zero; found [%d]", limit);
        validateCaloriesBracket(minCalories, maxCalories);

        var fatRating = parseFatRating(fatRatingStr);
        var sorts = createSorts(sortParams);
        return new NutritionSearchRequestImpl(minCalories, maxCalories, sorts, fatRating, limit);
    }

    private static Food.FatRating parseFatRating(String fatRating) {
        if (isBlank(fatRating)) {
            return null;
        }

        try {
            return Food.FatRating.valueOf(fatRating.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Unknown Fat Rating [%s]".formatted(fatRating), ex);
        }
    }

    private static List<Sort> createSorts(List<String> sortCriteria) {
        if (sortCriteria == null) {
            return emptyList();
        }

        var sorts = sortCriteria.stream()
            .map(NutritionSearchRequestFactory::parseSort)
            .toList();

        var duplicateSortFields = findDuplicateSortFields(sorts);
        if (!duplicateSortFields.isEmpty()) {
            var duplicateFields = duplicateSortFields.stream()
                .map(SortField::toString)
                .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("Duplicate sort criteria found for fields named [%s]".formatted(
                duplicateFields));
        }

        return sorts;
    }

    private static Sort parseSort(String criterion) {
        Validate.isTrue(criterion.contains("_"), "Sort parameter format is 'fieldName_order'. Found [%s]",
            criterion);

        var parts = criterion.split("_", 2);
        SortField sortField;
        SortOrder sortOrder;

        try {
            sortField = SortField.valueOf(parts[0].trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("[%s] is not a sortable field".formatted(parts[0]));
        }

        try {
            sortOrder = SortOrder.valueOf(parts[1].trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Unknown sort order [%s]".formatted(parts[1]));
        }

        return new Sort(sortField, sortOrder);
    }

    private static List<SortField> findDuplicateSortFields(List<Sort> sorts) {
        return sorts.stream()
            .collect(groupingBy(Sort::field, counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() > 1)
            .map(Map.Entry::getKey)
            .toList();
    }

    private static void validateCaloriesBracket(
        Integer minCalories,
        Integer maxCalories
    ) {
        if (minCalories != null && minCalories < 0) {
            throw new IllegalArgumentException("minCalories must be greater than zero; found [%d]".formatted(minCalories));
        }
        if (maxCalories != null && maxCalories < 0) {
            throw new IllegalArgumentException("maxCalories must be greater than zero; found [%d]".formatted(maxCalories));
        }
        if (minCalories != null && maxCalories != null) {
            Validate.isTrue(minCalories <= maxCalories, "minCalories must be less than or equal to maxCalories");
        }
    }

    private record NutritionSearchRequestImpl(
        Integer minCalories,
        Integer maxCalories,
        List<Sort> sorts,
        Food.FatRating fatRating,
        int limit
    ) implements NutritionSearchRequest { }

}

