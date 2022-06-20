package com.quantum.market.utils

import com.fasterxml.uuid.Generators

object IdGenerator {
    private val GENERATOR = Generators.timeBasedGenerator()
    fun createId(): String {
        return GENERATOR.generate().toString()
    }
}