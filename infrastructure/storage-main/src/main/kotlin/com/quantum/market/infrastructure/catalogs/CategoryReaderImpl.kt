package com.quantum.market.infrastructure.catalogs

import com.quantum.market.domain.catalogs.model.Category
import com.quantum.market.domain.catalogs.model.CategoryReader
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoryReaderImpl private constructor(
    private val categoryRepository: CategoryRepository
) : CategoryReader {

    override fun getCategory(id: UUID): Category {
        val categoryEntity = categoryRepository.findById(id).orElseThrow()
        return Category.create(
            categoryEntity.code,
            categoryEntity.name,
        )
    }
}
