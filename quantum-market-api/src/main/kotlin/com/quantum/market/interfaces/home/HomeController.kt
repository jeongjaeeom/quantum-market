package com.quantum.market.interfaces.home

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @Value("\${spring.application.name}")
    private val applicationName: String? = null

    @GetMapping("/catalog")
    fun home(): String? = "Welcome $applicationName"
}
