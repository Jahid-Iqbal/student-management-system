package org.sms.courseservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sms.courseservice.dto.CourseDto;
import org.sms.courseservice.entity.Course;
import org.sms.courseservice.entity.CourseStatus;
import org.sms.courseservice.exception.DuplicateResourceException;
import org.sms.courseservice.exception.ResourceNotFoundException;
import org.sms.courseservice.mapper.CourseMapper;
import org.sms.courseservice.param.CourseParam;
import org.sms.courseservice.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseDto createCourse(CourseParam req) {
        log.info("Creating new course with code: {}", req.getCourseCode());

        if (courseRepo.existsByCourseCode(req.getCourseCode())) {
            throw new DuplicateResourceException("Course with code " + req.getCourseCode() + " already exists");
        }

        Course course = courseMapper.paramToCourse(req);
        Course savedCourse = courseRepo.save(course);

        log.info("Course created successfully with ID: {}", savedCourse.getId());
        return courseMapper.entityToDto(savedCourse);
    }

    @Override
    @Transactional(readOnly = true)
    public CourseDto getCourseById(Long id) {
        log.info("Fetching course with ID: {}", id);
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));
        return courseMapper.entityToDto(course);
    }

    @Override
    @Transactional(readOnly = true)
    public CourseDto getCourseByCourseCode(String courseCode) {
        log.info("Fetching course with code: {}", courseCode);
        Course course = courseRepo.findByCourseCode(courseCode)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with code: " + courseCode));
        return courseMapper.entityToDto(course);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseDto> getAllCourses() {
        log.info("Fetching all courses");
        return courseRepo.findAll().stream()
                .map(courseMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByStatus(CourseStatus status) {
        return List.of();
    }

    @Override
    public List<CourseDto> getCoursesByDepartment(String department) {
        return List.of();
    }

    @Override
    public List<CourseDto> getCoursesByInstructor(String instructor) {
        return List.of();
    }

    @Override
    public List<CourseDto> searchCoursesByName(String courseName) {
        return List.of();
    }

    @Override
    public List<CourseDto> getAvailableCourses() {
        return List.of();
    }

    @Override
    public List<CourseDto> getActiveCoursesByDepartment(String department) {
        return List.of();
    }

    @Override
    public CourseDto updateCourse(Long id, CourseParam req) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }

    @Override
    public CourseDto updateCourseStatus(Long id, CourseStatus status) {
        return null;
    }

    @Override
    public CourseDto incrementEnrollment(Long id) {
        return null;
    }

    @Override
    public CourseDto decrementEnrollment(Long id) {
        return null;
    }

    @Override
    public boolean isCourseAvailable(Long id) {
        return false;
    }
}
