package org.sms.studentservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sms.studentservice.dto.StudentDto;
import org.sms.studentservice.dto.param.StudentParam;
import org.sms.studentservice.enums.StudentStatus;
import org.sms.studentservice.exception.ResourceNotFoundException;
import org.sms.studentservice.mapper.StudentMapper;
import org.sms.studentservice.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.data.RepositoryMetricsAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepo studentRepo;


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
        return studentMapper.entityToDto(studentRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No student found with id "+id)));
    }

    @Override
    public StudentDto getStudentByEmail(String email) {
        return studentMapper.entityToDto(studentRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("No student found with id "+email)));
    }

    @Override
    public StudentDto getStudentByStudentId(String studentId) {
        return studentMapper.entityToDto(studentRepo.findByStudentId(studentId)
                .orElseThrow(()->new ResourceNotFoundException("No student found with student id "+ studentId)));
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentMapper.entitytoDtoList(studentRepo.findAll());
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
