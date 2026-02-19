package org.sms.courseservice.mapper;

import org.mapstruct.Mapper;
import org.sms.courseservice.dto.CourseDto;
import org.sms.courseservice.entity.Course;
import org.sms.courseservice.param.CourseParam;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto entityToDto(Course course);
    Course DtoToCourse(CourseDto courseDto);
    Course paramToCourse(CourseParam courseParam);
}
