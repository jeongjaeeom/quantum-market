package com.quantum.market.infrastructure.posts

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "category")
class CategoryEntity(
    @Id var id: String,
    var code: String,
    var name: String,
    @ManyToOne var parent: CategoryEntity? = null
) {
}