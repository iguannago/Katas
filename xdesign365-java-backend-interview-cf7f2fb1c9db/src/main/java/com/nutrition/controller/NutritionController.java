package com.nutrition.controller;

import com.nutrition.model.Food;
import com.nutrition.service.NutritionSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.nutrition.dto.NutritionSearchRequestFactory.newRequest;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class NutritionController {

    private static final Logger log = LoggerFactory.getLogger(NutritionController.class);

    private final NutritionSearchService nutritionSearchService;

    public NutritionController(NutritionSearchService nutritionSearchService) {
        this.nutritionSearchService = nutritionSearchService;
    }

    @GetMapping(path = "/nutrition")
    public List<Food> findFood(
        @RequestParam(name = "minCalories", required = false) Integer minCalories,
        @RequestParam(name = "maxCalories", required = false) Integer maxCalories,
        @RequestParam(name = "fatRating", required = false) String fatRating,
        @RequestParam(name = "sort", required = false) List<String> sortCriteria,
        @RequestParam(name = "limit", defaultValue = "1000") int limit
    ) {
        var request = newRequest(minCalories, maxCalories, sortCriteria, fatRating, limit);
        return nutritionSearchService.searchNutrition(request);
    }

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<String> handleExpectedErrors(Exception ex) {
        return ResponseEntity
            .badRequest()
            .body(ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedErrors(Throwable t) {
        log.error("Unexpected error", t);

        return ResponseEntity
            .internalServerError()
            .body("");
    }
}
