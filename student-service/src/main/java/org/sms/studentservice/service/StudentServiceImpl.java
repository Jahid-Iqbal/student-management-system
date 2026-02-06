package org.sms.studentservice.service;

import org.sms.studentservice.dto.StudentDto;
import org.sms.studentservice.dto.param.StudentParam;
import org.sms.studentservice.enums.StudentStatus;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    @Override
    public StudentDto createStudent(StudentParam req) {
        return null;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return null;
    }

    @Override
    public StudentDto getStudentByEmail(String email) {
        return null;
    }

    @Override
    public StudentDto getStudentByStudentId(String studentId) {
        return null;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return List.of();
    }

    @Override
    public List<StudentDto> getStudentsByStatus(StudentStatus status) {
        return List.of();
    }

    @Override
    public List<StudentDto> searchStudentsByName(String name) {
        return List.of();
    }

    @Override
    public StudentDto updateStudent(Long id, StudentParam studentDTO) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }

    @Override
    public StudentDto updateStudentStatus(Long id, StudentStatus status) {
        return null;
    }
}
