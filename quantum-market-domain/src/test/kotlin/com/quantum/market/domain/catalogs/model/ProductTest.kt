package com.quantum.market.domain.catalogs.model

import com.quantum.market.domain.catalogs.model.Product
import com.quantum.market.domain.catalogs.model.ProductItem
import com.quantum.market.domain.catalogs.model.Sku
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductTest {
    @Test
    internal fun `상품생성`() {
        val sku1 = Sku.registry("SKU01", "파프리카 1입(빨강)", 100)
        val sku2 = Sku.registry("SKU01", "파프리카 1입(빨강)", 100)
        val product = Product.registry(
            "P202206200001",
            "한끼 파프리카 1입 2종",
            ProductItem.base(sku1, "파프리카 1입(빨강)", 5000)
        ).addItem(ProductItem.base(sku2, "파프리카 1입(노랑)", 5500))
        assertThat(product.items).hasSize(2)
    }
}
