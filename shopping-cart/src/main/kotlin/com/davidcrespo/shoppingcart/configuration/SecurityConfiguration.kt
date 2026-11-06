package com.davidcrespo.shoppingcart.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration(proxyBeanMethods = false)
class SecurityConfiguration {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests {
                it.requestMatchers("/carts", "/carts/**").authenticated()
                it.anyRequest().denyAll()
            }
            .oauth2ResourceServer { it.jwt(Customizer.withDefaults()) }
            .formLogin { it.disable() }
            .httpBasic { it.disable() }

        return http.build()
    }
}