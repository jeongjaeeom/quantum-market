package com.quantum.market.domain.catalogs.model

import com.quantum.market.utils.IdGenerator
import java.util.*

class Product private constructor(
    val id: UUID,
    val code: String,
    val name: String,
    items: MutableSet<ProductItem>,
    categories: MutableSet<Category>
) {
    var items: MutableSet<ProductItem> = items
        private set

    var categories: MutableSet<Category> = categories
        private set

    fun category(category: Category): Product {
        categories.add(category)
        return this
    }

    fun addItem(additionalItem: Set<ProductItem>): Product {
        items.addAll(additionalItem)
        return this
    }

    fun addItem(additionalItem: ProductItem): Product {
        items.add(additionalItem)
        return this
    }

    companion object {
        fun registry(code: String, name: String, baseItem: ProductItem): Product {
            return Product(IdGenerator.createId(), code, name, mutableSetOf(baseItem), mutableSetOf())
        }
    }

}
