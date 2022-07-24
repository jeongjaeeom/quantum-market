package com.quantum.market.api.catalogs.interfaces

import com.quantum.market.api.catalogs.application.CategoryService
import com.quantum.market.domain.catalogs.model.Category
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    @PostMapping
    fun create(): Category {
        return categoryService.store()
    }

    @GetMapping("/{id}")
    fun getCategory(@PathVariable("id") categoryId: UUID): Category {
        return categoryService.getCategory(categoryId)
    }

}
