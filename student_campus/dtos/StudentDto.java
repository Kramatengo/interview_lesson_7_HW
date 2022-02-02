package ru.alexander_kramarenko.student_campus.dtos;

import ru.alexander_kramarenko.student_campus.model.Student;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class StudentDto {
    private Long id;

    @NotNull(message = "Студент должен иметь имя")
    @Length(min = 1, max = 255, message = "Длина имени студента должна составлять 1-255 символов")
    private String name;

    @Min(value = 15, message = "Возраст студента не может быть менее 15 лет")
    private int age;

    @NotNull(message = "Студент должен иметь категорию")
    private String categoryTitle;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
        this.categoryTitle = student.getCategory().getTitle();
    }
}
