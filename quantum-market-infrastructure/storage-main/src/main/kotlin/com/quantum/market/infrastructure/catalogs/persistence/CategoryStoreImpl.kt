package com.quantum.market.infrastructure.catalogs.persistence

import com.quantum.market.domain.catalogs.model.Category
import com.quantum.market.domain.catalogs.model.CategoryStore
import org.springframework.stereotype.Component

@Component
class CategoryStoreImpl private constructor(
    private val categoryRepository: CategoryRepository
) : CategoryStore{
    override fun store(category: Category): Category {
        val categoryEntity = CategoryEntity(
            id = category.id,
            code = category.code,
            name = category.name,
        )
        val savedCategory = categoryRepository.save(categoryEntity)
        return Category.Companion.create(
            savedCategory.id,
            savedCategory.code,
            savedCategory.name,
        )
    }
}
