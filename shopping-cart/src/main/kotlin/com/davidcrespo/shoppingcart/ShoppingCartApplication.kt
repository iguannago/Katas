package com.davidcrespo.shoppingcart

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ShoppingCartApplication {

    @Suppress("unused")
    fun main(args: Array<String>) {
        SpringApplication.run(ShoppingCartApplication::class.java, *args)
    }
}