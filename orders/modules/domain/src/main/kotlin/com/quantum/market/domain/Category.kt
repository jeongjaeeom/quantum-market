package com.quantum.market.domain

import com.quantum.market.utils.IdGenerator

class Category private constructor(
    private val id: String,
    val code: String,
    var name: String,
    private var parent: Category?,
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
    }

}