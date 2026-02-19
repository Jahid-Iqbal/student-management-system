package org.sms.courseservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sms.courseservice.dto.CourseDto;
import org.sms.courseservice.param.CourseParam;
import org.sms.courseservice.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseParam req) {
        log.info("REST request to create course: {}", req);
        CourseDto createdCourse = courseService.createCourse(req);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id) {
        log.info("REST request to get course by ID: {}", id);
        CourseDto course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/code/{courseCode}")
    public ResponseEntity<CourseDto> getCourseByCourseCode(@PathVariable String courseCode) {
        log.info("REST request to get course by code: {}", courseCode);
        CourseDto course = courseService.getCourseByCourseCode(courseCode);
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        log.info("REST request to get all courses");
        List<CourseDto> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

}
