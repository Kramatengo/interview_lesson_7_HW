package ru.alexander_kramarenko.student_campus.repositories;

import ru.alexander_kramarenko.student_campus.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTitle(String title);

    @Query("select c from Category c join fetch c.students where c.id = :id")
    Optional<Category> findByIdWithStudents(Long id);
}
