package com.davidcrespo.shoppingcart.adapter.inbound.web

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*

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

    @Test
    fun `requesting a receipt for an unknown cart returns not found`() {
        val unknownCartId = UUID.randomUUID()

        mockMvc.perform(get("/carts/$unknownCartId/receipt"))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `adding a product makes it appear on the cart receipt`() {
        val creationResult = mockMvc.perform(post("/carts"))
            .andExpect(status().isCreated)
            .andReturn()

        val location = requireNotNull(
            creationResult.response.getHeader("Location")
        )

        mockMvc.perform(
            post("$location/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
                {
                    "id": "cornflakes",
                    "name": "Cornflakes",
                    "price": 2.50
                }
                """.trimIndent()
                )
        )
            .andExpect(status().isNoContent)

        mockMvc.perform(get("$location/receipt"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.lines.length()").value(1))
            .andExpect(jsonPath("$.lines[0].product.id").value("cornflakes"))
            .andExpect(jsonPath("$.lines[0].product.name").value("Cornflakes"))
            .andExpect(jsonPath("$.lines[0].product.price").value(2.50))
            .andExpect(jsonPath("$.lines[0].quantity").value(1))
            .andExpect(jsonPath("$.subtotal").value(2.50))
            .andExpect(jsonPath("$.discount").value(0))
            .andExpect(jsonPath("$.total").value(2.50))
    }
}