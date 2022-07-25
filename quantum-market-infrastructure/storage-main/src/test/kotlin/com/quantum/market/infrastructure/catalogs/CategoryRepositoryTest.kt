package com.quantum.market.infrastructure.catalogs

import com.quantum.market.infrastructure.catalogs.persistence.CategoryEntity
import com.quantum.market.infrastructure.catalogs.persistence.CategoryRepository
import com.quantum.market.utils.IdGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@DataJpaTest
internal class CategoryRepositoryTest @Autowired constructor(
    val categoryRepository: CategoryRepository
) {
    @Test
    internal fun `카테고리_엔티티_생성`() {
        val categoryEntity = CategoryEntity(IdGenerator.createId(), "VEGETABLE", "채소")
        val savedCategory = categoryRepository.save(categoryEntity)
        assertThat(savedCategory.code).isEqualTo("VEGETABLE")
        assertThat(savedCategory.name).isEqualTo("채소")
    }
}
