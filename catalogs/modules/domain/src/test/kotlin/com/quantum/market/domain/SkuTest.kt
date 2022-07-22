package com.quantum.market.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalStateException
import org.junit.jupiter.api.Test

internal class SkuTest {
    @Test
    internal fun `SKU_생성`() {
        val sku = Sku.registry("SKU01", "브로콜리 1입", 100)
        assertThat(sku).isEqualTo(Sku.registry("SKU01", "브로콜리 1입"))
    }

    @Test
    internal fun `재고수량_추가`() {
        val sku = Sku.registry("SKU02", "파프리카 1입")
        sku.fillIn(100)
        assertThat(sku.stockQuantity).isEqualTo(100)
    }

    @Test
    internal fun `재고수량_소진`() {
        val sku = Sku.registry("SKU02", "파프리카 11입", 100)
        sku.reduceStockQuantity(50)
        assertThat(sku.stockQuantity).isEqualTo(50)
    }

    @Test
    internal fun `SKU_재고수량_품절_예외처리`() {
        val sku = Sku.registry("SKU02", "파프리카 11입", 100)
        assertThatIllegalStateException().isThrownBy { sku.reduceStockQuantity(101) }
    }
}