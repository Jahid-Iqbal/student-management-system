package org.sms.studentservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sms.studentservice.dto.StudentDto;
import org.sms.studentservice.dto.param.StudentParam;
import org.sms.studentservice.entity.Student;
import org.sms.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("{id}")
    ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        log.info("REST request to get student by ID: {}", id);
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        log.info("REST request to get all students");
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentParam req){
        log.info("REST request to create student: {}", req);
        return new ResponseEntity<>(studentService.createStudent(req), HttpStatus.CREATED);
    }

    @GetMapping("stdid/{studentId}")
    ResponseEntity<StudentDto> getStudentByStudentId(@PathVariable String studentId){
        return new ResponseEntity<>(studentService.getStudentByStudentId(studentId), HttpStatus.OK);
    }



}
