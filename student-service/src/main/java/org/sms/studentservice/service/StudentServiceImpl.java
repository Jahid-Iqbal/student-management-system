package org.sms.studentservice.service;

import org.sms.studentservice.dto.StudentDto;
import org.sms.studentservice.dto.param.StudentParam;
import org.sms.studentservice.entity.Student;
import org.sms.studentservice.enums.StudentStatus;
import org.sms.studentservice.mapper.StudentMapper;
import org.sms.studentservice.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.data.RepositoryMetricsAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private RepositoryMetricsAutoConfiguration repositoryMetricsAutoConfiguration;

    @Override
    public StudentDto createStudent(StudentParam req) {
        return studentMapper.entityToDto(
                studentRepo.save(
                        studentMapper.paramToEntity(req)
                )
        );
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return studentMapper.entityToDto(studentRepo.findById(id).orElseThrow());
    }

    @Override
    public StudentDto getStudentByEmail(String email) {
        return studentMapper.entityToDto(studentRepo.findByEmail(email).orElseThrow());
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
