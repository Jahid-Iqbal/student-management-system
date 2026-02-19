package org.sms.courseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sms.courseservice.entity.CourseStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private Long id;
    private String courseCode;
    private String courseName;
    private String description;
    private Integer credits;
    private String department;
    private String instructor;
    private Integer capacity;
    private Integer enrolledStudents;
    private CourseStatus status;
}
