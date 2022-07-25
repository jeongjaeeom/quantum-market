package com.quantum.market.domain.catalogs.model

interface CategoryStore {

    fun store(category: Category): Category
}
