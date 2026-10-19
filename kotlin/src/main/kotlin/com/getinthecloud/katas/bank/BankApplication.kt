package com.getinthecloud.katas.bank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(proxyBeanMethods = false)
class BankApplication

fun main(args: Array<String>) {
    runApplication<BankApplication>(*args)
}
