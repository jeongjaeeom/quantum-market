package com.quantum.market.domain.catalogs.model

import com.quantum.market.utils.IdGenerator
import java.util.*

class Sku private constructor(
    val id: UUID,
    val code: String,
    val name: String,
    var stockQuantity: Long
) {
    fun fillIn(quantity: Long) {
        this.stockQuantity += quantity
    }

    fun reduceStockQuantity(quantity: Long) {
        verifyAvailability(quantity)
        this.stockQuantity -= quantity
    }

    private fun verifyAvailability(quantity: Long) {
        if (this.stockQuantity < quantity) {
            throw IllegalStateException("Out of Stock")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Sku

        if (code != other.code) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = code.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    companion object {
        fun registry(code: String, name: String): Sku {
            return Sku(IdGenerator.createId(), code, name, 0)
        }

        fun registry(code: String, name: String, stockQuantity: Long): Sku {
            return Sku(IdGenerator.createId(), code, name, stockQuantity)
        }
    }


}
