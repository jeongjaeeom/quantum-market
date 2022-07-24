package com.quantum.market.infrastructure.catalogs

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "category")
internal class CategoryEntity(
    @Id @Column(columnDefinition = "BINARY(16)") val id: UUID,
    val code: String,
    val name: String,
    @ManyToOne val parent: CategoryEntity? = null
)
