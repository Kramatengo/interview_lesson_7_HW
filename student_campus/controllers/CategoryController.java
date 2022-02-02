package ru.alexander_kramarenko.student_campus.controllers;

import ru.alexander_kramarenko.student_campus.dtos.CategoryDto;
import ru.alexander_kramarenko.student_campus.exceptions.ResourceNotFoundException;
import ru.alexander_kramarenko.student_campus.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return new CategoryDto(categoryService.findByIdWithStudents(id).orElseThrow(() -> new ResourceNotFoundException("Category id = " + id + " not found")));
    }
}
