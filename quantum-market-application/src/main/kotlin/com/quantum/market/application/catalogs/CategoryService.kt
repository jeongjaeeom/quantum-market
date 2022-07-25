package com.quantum.market.application.catalogs

import com.quantum.market.domain.catalogs.model.Category
import com.quantum.market.domain.catalogs.model.CategoryReader
import com.quantum.market.domain.catalogs.model.CategoryStore
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(
    private val categoryStore: CategoryStore,
    private val categoryReader: CategoryReader
) {

    fun store() : Category {
        val category = Category.create("VEGETABLE", "채소")
        return categoryStore.store(category)
    }

    fun getCategory(id: UUID) : Category {
        return categoryReader.getCategory(id)
    }
}
