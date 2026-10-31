package com.davidcrespo.shoppingcart.adapter.inbound.web

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
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

    @Nested
    inner class CreatingCarts {

        @Test
        fun `creating a cart returns its identifier and location`() {
            mockMvc.perform(post("/carts"))
                .andExpect(status().isCreated)
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.id").isNotEmpty)
        }
    }

    @Nested
    inner class RetrievingReceipts {

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
                .andExpect(
                    content().contentTypeCompatibleWith(
                        MediaType.APPLICATION_PROBLEM_JSON
                    )
                )
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.title").value("Not Found"))
                .andExpect(jsonPath("$.detail").isNotEmpty)
        }
    }

    @Nested
    inner class AddingProducts {

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

        @ParameterizedTest(name = "price {0} returns bad request")
        @ValueSource(strings = ["0.00", "-0.01", "-2.50"])
        fun `adding a product with a non-positive price is rejected`(
            price: String
        ) {
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
                        "price": $price
                    }
                    """.trimIndent()
                    )
            )
                .andExpect(status().isBadRequest)
                .andExpect(
                    content().contentTypeCompatibleWith(
                        MediaType.APPLICATION_PROBLEM_JSON
                    )
                )
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.title").value("Bad Request"))
                .andExpect(jsonPath("$.detail").isNotEmpty)
                .andExpect(jsonPath("$.errors.price").isNotEmpty)

            mockMvc.perform(get("$location/receipt"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.lines").isEmpty)
                .andExpect(jsonPath("$.total").value(0))
        }

        @ParameterizedTest(name = "blank product ID case {index} returns bad request")
        @ValueSource(strings = ["", " ", "   "])
        fun `adding a product with a blank identifier is rejected`(
            productId: String
        ) {
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
                        "id": "$productId",
                        "name": "Cornflakes",
                        "price": 2.50
                    }
                    """.trimIndent()
                    )
            )
                .andExpect(status().isBadRequest)
                .andExpect(
                    content().contentTypeCompatibleWith(
                        MediaType.APPLICATION_PROBLEM_JSON
                    )
                )
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.title").value("Bad Request"))
                .andExpect(jsonPath("$.detail").isNotEmpty)
                .andExpect(jsonPath("$.errors.id").isNotEmpty)

            mockMvc.perform(get("$location/receipt"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.lines").isEmpty)
                .andExpect(jsonPath("$.total").value(0))
        }

        @Test
        fun `malformed product JSON returns a problem response`() {
            val creationResult = mockMvc.perform(post("/carts"))
                .andExpect(status().isCreated)
                .andReturn()

            val location = requireNotNull(
                creationResult.response.getHeader("Location")
            )

            mockMvc.perform(
                post("$location/items")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"id": "cornflakes", "price": }""")
            )
                .andExpect(status().isBadRequest)
                .andExpect(
                    content().contentTypeCompatibleWith(
                        MediaType.APPLICATION_PROBLEM_JSON
                    )
                )
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.title").value("Bad Request"))
                .andExpect(jsonPath("$.detail").isNotEmpty)

            mockMvc.perform(get("$location/receipt"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.lines").isEmpty)
                .andExpect(jsonPath("$.total").value(0))
        }
    }
}
