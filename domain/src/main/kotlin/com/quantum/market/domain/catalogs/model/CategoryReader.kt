package com.quantum.market.domain.catalogs.model

import java.util.*

interface CategoryReader {

    fun getCategory(id: UUID) : Category
}
