package com.nutrition.service;

import com.nutrition.dto.NutritionSearchRequest;
import com.nutrition.dto.Sort;
import com.nutrition.dto.SortField;
import com.nutrition.dto.SortOrder;
import com.nutrition.model.Food;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static com.nutrition.model.Food.FatRating.HIGH;
import static com.nutrition.model.Food.FatRating.LOW;
import static com.nutrition.model.Food.FatRating.MEDIUM;
import static com.nutrition.util.CsvColumnHeading.CAFFEINE_FIELD;
import static com.nutrition.util.CsvColumnHeading.CALORIES_FIELD;
import static com.nutrition.util.CsvColumnHeading.NAME_FIELD;
import static com.nutrition.util.CsvColumnHeading.SERVING_SIZE;
import static com.nutrition.util.CsvColumnHeading.TOTAL_FAT_FIELD;
import static java.nio.charset.StandardCharsets.UTF_8;

public final class NutritionSearchService {

    private static final EnumMap<SortField, Comparator<Food>> FIELD_COMPARATORS = new EnumMap<>(SortField.class);

    static {
        FIELD_COMPARATORS.put(SortField.CALORIES, Comparator.comparing(
            Food::calories, Comparator.naturalOrder()));
        FIELD_COMPARATORS.put(SortField.NAME, Comparator.comparing(
            Food::name, String.CASE_INSENSITIVE_ORDER));
    }

    private final File csvFile;

    public NutritionSearchService(File csvFile) {
        this.csvFile = csvFile;
    }

    public List<Food> searchNutrition(NutritionSearchRequest request) {

        return loadFromCsvFile(csvFile).stream()
                .filter(item -> request.fatRating() == null || item.fatRating() == request.fatRating())
                .filter(item -> request.maxCalories() == null || item.calories() <= request.maxCalories())
            .limit(request.limit())
            .sorted(buildComparator(request))
            .toList();
    }

    private Comparator<Food> buildComparator(NutritionSearchRequest request) {
        return request.sorts().stream()
            .map(this::getComparator)
            .reduce(Comparator::thenComparing)
            .orElse((h1, h2) -> 0);
    }

    private Comparator<Food> getComparator(Sort sort) {
        var comparator = FIELD_COMPARATORS.get(sort.field());
        return sort.order() == SortOrder.ASC ? comparator : comparator.reversed();
    }

    private static List<Food> loadFromCsvFile(File file) {
        try (var csvReader = new CSVReaderHeaderAware(new FileReader(file, UTF_8))) {

            Map<String, String> rowData;
            var foods = new ArrayList<Food>();

            while ((rowData = csvReader.readMap()) != null) {
                if (isValidFood(rowData)) {
                    foods.add(createFood(rowData));
                }
            }

            return foods;
        } catch (IOException | CsvValidationException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static boolean isValidFood(Map<String, String> rowData) {
        return isValidRow(rowData) && rowData.get(SERVING_SIZE).equals("100 g");
    }

    private static boolean isValidRow(Map<String, String> rowData) {
        var requiredFields = List.of(NAME_FIELD, CALORIES_FIELD, TOTAL_FAT_FIELD, CAFFEINE_FIELD, SERVING_SIZE);

        return rowData.entrySet().stream()
            .filter(e1 -> requiredFields.contains(e1.getKey()))
            .noneMatch(e2 -> e2.getValue().isBlank());
    }

    private static Food createFood(Map<String, String> rowData) {
        var name = rowData.get(NAME_FIELD);
        var calories = Integer.parseInt(rowData.get(CALORIES_FIELD));
        var totalFat = Double.parseDouble(rowData.get(TOTAL_FAT_FIELD).substring(0, rowData.get(TOTAL_FAT_FIELD).indexOf('g')));
        var fatRating = getFatRating(totalFat);
        var caffeine = rowData.get(CAFFEINE_FIELD);

        return new Food(name, calories, totalFat, fatRating, caffeine);
    }

    private static Food.FatRating getFatRating(Double totalFat) {
        if (totalFat >= 17.5) {
            return HIGH;
        } else if (totalFat <= 3) {
            return LOW;
        } else {
            return MEDIUM;
        }
    }
}
