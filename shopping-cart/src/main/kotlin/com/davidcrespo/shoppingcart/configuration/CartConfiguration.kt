package com.davidcrespo.shoppingcart.configuration

import com.davidcrespo.shoppingcart.adapter.outbound.memory.InMemoryCartStore
import com.davidcrespo.shoppingcart.application.port.input.CartUseCases
import com.davidcrespo.shoppingcart.application.port.output.CartStore
import com.davidcrespo.shoppingcart.application.service.CartUserCasesImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
class CartConfiguration {

    @Bean
    fun cartStore(): CartStore = InMemoryCartStore()

    @Bean
    fun cartUseCases(store: CartStore): CartUseCases = CartUserCasesImpl(store)

}