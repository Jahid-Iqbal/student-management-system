package org.sms.studentservice.repo;

import org.sms.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);
    Optional<Student> findByStudentId(String studentId);
}
