package ru.alexander_kramarenko.student_campus.services;

import ru.alexander_kramarenko.student_campus.model.Category;
import ru.alexander_kramarenko.student_campus.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }


    public Optional<Category> findByIdWithStudents(Long id) {
        return categoryRepository.findByIdWithStudents(id);
    }
}
