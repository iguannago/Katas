package com.davidcrespo.shoppingcart

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class CartControllerTest @Autowired constructor(
    private val mockMvc: MockMvc
) {

    @Test
    fun `creating a cart returns its identifier and location`() {
        mockMvc.perform(post("/carts"))
            .andExpect(status().isCreated)
            .andExpect(header().exists("Location"))
            .andExpect(jsonPath("$.id").isNotEmpty)
    }

    @Test
    fun `a newly created cart returns an empty receipt`() {
        val creationResult = mockMvc.perform(post("/carts"))
            .andExpect(status().isCreated)
            .andReturn()

        val location = requireNotNull(
            creationResult.response.getHeader("Location")
        )

        mockMvc.perform(get("$location/receipt"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.lines").isEmpty)
            .andExpect(jsonPath("$.subtotal").value(0))
            .andExpect(jsonPath("$.discount").value(0))
            .andExpect(jsonPath("$.total").value(0))
    }
}