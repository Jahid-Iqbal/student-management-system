package org.sms.courseservice.services;

import org.sms.courseservice.dto.CourseDto;
import org.sms.courseservice.entity.CourseStatus;
import org.sms.courseservice.param.CourseParam;

import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseParam req);

    CourseDto getCourseById(Long id);

    CourseDto getCourseByCourseCode(String courseCode);

    List<CourseDto> getAllCourses();

    List<CourseDto> getCoursesByStatus(CourseStatus status);

    List<CourseDto> getCoursesByDepartment(String department);

    List<CourseDto> getCoursesByInstructor(String instructor);

    List<CourseDto> searchCoursesByName(String courseName);

    List<CourseDto> getAvailableCourses();

    List<CourseDto> getActiveCoursesByDepartment(String department);

    CourseDto updateCourse(Long id, CourseParam req);

    void deleteCourse(Long id);

    CourseDto updateCourseStatus(Long id, CourseStatus status);

    CourseDto incrementEnrollment(Long id);

    CourseDto decrementEnrollment(Long id);

    boolean isCourseAvailable(Long id);
}
