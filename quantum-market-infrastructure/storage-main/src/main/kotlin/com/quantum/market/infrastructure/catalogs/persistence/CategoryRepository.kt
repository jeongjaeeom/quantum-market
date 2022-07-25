package com.quantum.market.infrastructure.catalogs.persistence

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

internal interface CategoryRepository : JpaRepository<CategoryEntity, UUID> {
}
