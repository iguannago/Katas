package com.nutrition;

import com.nutrition.exception.CsvFileLoadingException;
import com.nutrition.service.NutritionSearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class NutritionSearchApplication {

    @Value("${nutrition-search.data.file.name}")
    private String nutritionDataFile;

    @Bean
    public NutritionSearchService nutritionSearchService() {
        return new NutritionSearchService(csvFile());
    }

    @Bean
    public File csvFile() {
        try {
            var nutritionData = new ClassPathResource(nutritionDataFile);
            return nutritionData.getFile();
        } catch (IOException ex) {
            throw new CsvFileLoadingException(ex);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(NutritionSearchApplication.class, args);
    }
}
