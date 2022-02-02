package ru.alexander_kramarenko.student_campus.repositories;

import org.springframework.transaction.annotation.Transactional;
import ru.alexander_kramarenko.student_campus.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    @Transactional
    void deleteStudentByIdEquals(long id);

}
