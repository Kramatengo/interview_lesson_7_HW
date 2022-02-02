package ru.alexander_kramarenko.student_campus.controllers;

import org.springframework.http.HttpStatus;
import ru.alexander_kramarenko.student_campus.dtos.StudentDto;
import ru.alexander_kramarenko.student_campus.exceptions.DataValidationException;
import ru.alexander_kramarenko.student_campus.exceptions.ResourceNotFoundException;
import ru.alexander_kramarenko.student_campus.model.Category;
import ru.alexander_kramarenko.student_campus.model.Student;
import ru.alexander_kramarenko.student_campus.services.CategoryService;
import ru.alexander_kramarenko.student_campus.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final CategoryService categoryService;

    @GetMapping
    public Page<StudentDto> findAll(@RequestParam(defaultValue = "1", name = "p") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return studentService.findAll(pageIndex - 1, 10).map(StudentDto::new);
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable Long id) {
        return new StudentDto(studentService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student id = " + id + " not found")));
    }

    @PostMapping
    public StudentDto save(@RequestBody @Validated StudentDto studentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataValidationException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
        }
        Student student = new Student();
        student.setAge(studentDto.getAge());
        student.setName(studentDto.getName());
        Category category = categoryService.findByTitle(studentDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category title = " + studentDto.getCategoryTitle() + " not found"));
        student.setCategory(category);
        studentService.save(student);
        return new StudentDto(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody StudentDto studentDto) {
        studentService.updateStudentFromDto(studentDto);
    }

    @DeleteMapping("/{id}")
    public int deleteStudentByIdEquals(@PathVariable long id) {
        studentService.deleteStudentByIdEquals(id);
        return HttpStatus.OK.value();
    }


}
