package com.quantum.market.catalogs.interfaces

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController {

    @Value("\${spring.application.name}")
    private val applicationName: String? = null

    @GetMapping("/order")
    fun home(): String? = "Welcome $applicationName"
}