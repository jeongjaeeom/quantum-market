package com.quantum.market.catalogs.domain

import com.quantum.market.domain.catalogs.model.ProductItem
import com.quantum.market.domain.catalogs.model.Sku
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductItemTest {
    @Test
    internal fun `판매물품_등록`() {
        val sku = Sku.registry("SKU01", "파프리카 1입(빨강)", 100)
        val productItem = ProductItem.base(sku, "파프리카 1입(빨강)", 5000)
        assertThat(productItem).isEqualTo(ProductItem.base(sku, "파프리카 1입(빨강)", 5000))
        assertThat(productItem.base).isTrue
    }

    @Test
    internal fun `추가_판매물품_등록`() {
        val sku = Sku.registry("SKU01", "파프리카 1입(노랑)", 50)
        val productItem = ProductItem.addition(sku, "파프리카 1입", 5000)
        assertThat(productItem.base).isFalse
    }
}
