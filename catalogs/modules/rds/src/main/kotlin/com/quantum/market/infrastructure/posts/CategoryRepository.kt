package com.quantum.market.infrastructure.posts

import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<CategoryEntity, String> {
}