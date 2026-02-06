package org.sms.studentservice.service;

import org.sms.studentservice.dto.StudentDto;
import org.sms.studentservice.dto.param.StudentParam;
import org.sms.studentservice.enums.StudentStatus;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentParam req);
    StudentDto getStudentById(Long id);
    StudentDto getStudentByEmail(String email);
    StudentDto getStudentByStudentId(String studentId);
    List<StudentDto> getAllStudents();
    List<StudentDto> getStudentsByStatus(StudentStatus status);
    List<StudentDto> searchStudentsByName(String name);
    StudentDto updateStudent(Long id, StudentParam studentDTO);
    void deleteStudent(Long id);
    StudentDto updateStudentStatus(Long id, StudentStatus status);
}
