package ru.alexander_kramarenko.student_campus.dtos;

import ru.alexander_kramarenko.student_campus.model.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;
    private List<StudentDto> students;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.students = category.getStudents().stream().map(StudentDto::new).collect(Collectors.toList());
    }
}
