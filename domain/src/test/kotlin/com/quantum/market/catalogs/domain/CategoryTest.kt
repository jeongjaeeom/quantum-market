package com.quantum.market.catalogs.domain

import com.quantum.market.domain.catalogs.model.Category
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CategoryTest {
    @Test
    internal fun `카테고리_생성`() {
        val category = Category.create("VEGETABLE", "채소")
        assertThat(category.code).isEqualTo("VEGETABLE")
    }

    @Test
    internal fun `카테고리_자식카테고리_추가`() {
        val category = Category.create("VEGETABLE", "채소")
        category.child("BROCCOLI","브로콜리")
        category.child("PAPRIKA","파프리카")
        assertThat(category.children).hasSize(2)
    }
}
