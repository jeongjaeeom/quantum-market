package com.quantum.market.domain.catalogs

import com.quantum.market.money.Money
import com.quantum.market.utils.IdGenerator

class ProductItem private constructor(
    val id: String,
    val sku: Sku,
    var name: String,
    var price: Money,
    var base: Boolean
) {
    companion object {
        fun base(sku: Sku, name: String, price: Long): ProductItem {
            return ProductItem(IdGenerator.createId(), sku, name, Money.wons(price), true)
        }

        fun addition(sku: Sku, name: String, price: Long): ProductItem {
            return ProductItem(IdGenerator.createId(), sku, name, Money.wons(price), false)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductItem

        if (sku != other.sku) return false
        if (name != other.name) return false
        if (price != other.price) return false

        return true
    }

    override fun hashCode(): Int {
        var result = sku.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + price.hashCode()
        return result
    }


}