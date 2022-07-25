package com.quantum.market.domain.catalogs.model

import com.quantum.market.utils.IdGenerator
import java.util.*

class Category private constructor(
    val id: UUID,
    val code: String,
    val name: String,
    var parent: Category?,
    val children: MutableList<Category> = mutableListOf()
) {
    fun child(code: String, name: String): Category {
        val child = create(code, name)
        child.parent = this
        children.add(child)
        return child
    }

    companion object {
        fun create(code: String, name: String): Category {
            return Category(IdGenerator.createId(), code, name, null)
        }

        fun create(id: UUID, code: String, name: String): Category {
            return Category(id, code, name, null)
        }
    }

}
