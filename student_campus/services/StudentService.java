package ru.alexander_kramarenko.student_campus.services;

import ru.alexander_kramarenko.student_campus.dtos.StudentDto;
import ru.alexander_kramarenko.student_campus.exceptions.ResourceNotFoundException;
import ru.alexander_kramarenko.student_campus.model.Category;
import ru.alexander_kramarenko.student_campus.model.Student;
import ru.alexander_kramarenko.student_campus.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CategoryService categoryService;


    public Page<Student> findAll(int pageIndex, int pageSize) {
        return studentRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void updateStudentFromDto(StudentDto studentDto) {
        Student student = findById(studentDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Student id = " + studentDto.getId() + " not found"));
        student.setAge(studentDto.getAge());
        student.setName(studentDto.getName());
        if (!student.getCategory().getTitle().equals(studentDto.getCategoryTitle())) {
            Category category = categoryService.findByTitle(studentDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category title = " + studentDto.getCategoryTitle() + " not found"));
            student.setCategory(category);
        }
    }

    public void deleteStudentByIdEquals(long id) {
        studentRepository.deleteStudentByIdEquals(id);
    }


}
