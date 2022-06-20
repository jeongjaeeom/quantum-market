package com.quantum.market.domain.catalogs

import com.quantum.market.utils.IdGenerator

class Product private constructor(
    val id: String,
    val code: String,
    var name: String,
    var items: MutableSet<ProductItem>,
    var categories: MutableSet<Category> = mutableSetOf()
) {
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
            return Product(IdGenerator.createId(), code, name, mutableSetOf(baseItem))
        }
    }

}