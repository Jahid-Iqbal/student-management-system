package org.sms.studentservice.mapper;

import org.mapstruct.Mapper;
import org.sms.studentservice.dto.StudentDto;
import org.sms.studentservice.dto.param.StudentParam;
import org.sms.studentservice.entity.Student;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto entityToDto(Student student);
    Student dtoToEntity(StudentDto studentDto);
    Student paramToEntity(StudentParam studentParam);
    List<StudentDto> entitytoDtoList(List<Student> students);
}
