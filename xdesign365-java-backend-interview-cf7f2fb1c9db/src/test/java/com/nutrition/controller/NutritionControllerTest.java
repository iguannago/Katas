package com.nutrition.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.file.Files;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class NutritionControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setup(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void should_return_all_items() throws Exception {
        mockMvc.perform(get("/nutrition")
                .accept(APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON))
            .andExpect(content().json(readJsonFile("all-foods.json"), true));
    }

    @Test
    void should_return_only_low_fat() throws Exception {
        mockMvc.perform(get("/nutrition?fatRating=LOW")
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(readJsonFile("all-low-fat-foods.json"), true));
    }

    @Test
    void should_return_low_fat_300_calories_or_less() throws Exception {
        mockMvc.perform(get("/nutrition?fatRating=LOW&maxCalories=300")
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(readJsonFile("low-fat-under-300-cals.json"), true));
    }

    @Nested
    @Disabled("Until filtering is implemented")
    class FilteringTest {



        @Test
        void should_return_high_fat_300_calories_or_more() throws Exception {
            mockMvc.perform(get("/nutrition?fatRating=HIGH&minCalories=300")
                    .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(readJsonFile("high-fat-over-300-cals.json"), true));
        }

        @Test
        void should_return_items_exactly_300_calories() throws Exception {
            mockMvc.perform(get("/nutrition?minCalories=300&maxCalories=300")
                    .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(readJsonFile("all-foods-exactly-300-cals.json"), true));
        }
    }

    @Nested
    @Disabled("Until all steps implemented")
    class AllParamsTest {

        @Test
        void should_return_five_highest_fat_items_ordered_calories_desc() throws Exception {
            mockMvc.perform(get("/nutrition?fatRating=HIGH&sort=calories_desc&limit=5")
                    .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(readJsonFile("high-fat-sort-by-cals-desc.json"), true));
        }

        @Test
        void should_return_first_five_low_fat_items_in_alphabetical_order_with_identical_calories_items_ordered_by_name_asc() throws Exception {
            mockMvc.perform(get("/nutrition?fatRating=LOW&sort=calories_desc&sort=name_asc&limit=5")
                    .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(readJsonFile("first-five-low-fat-ordered-by-calories-desc-then-name-asc.json"), true));
        }

        @Test
        void should_return_low_fat_200_cals_or_more_ordered_cals_desc() throws Exception {
            mockMvc.perform(get("/nutrition?fatRating=LOW&minCalories=400&sort=calories_desc")
                    .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(readJsonFile("low-fat-400-cals-or-more-sort-by-cals-desc.json"), true));
        }

        @Test
        void should_return_high_fat_900_cals_or_less_ordered_cals_asc() throws Exception {
            mockMvc.perform(get("/nutrition?fatRating=HIGH&maxCalories=200&sort=calories_asc")
                    .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json(readJsonFile("high-fat-max-cals-200-sort-by-cals-asc.json"), true));
        }
    }

    private String readJsonFile(String path) throws IOException {
        var resource = new ClassPathResource(path);
        return Files.readString(resource.getFile().toPath(), UTF_8);
    }

}
