package org.sms.courseservice.param;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sms.courseservice.entity.CourseStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseParam {

    @NotBlank(message = "Course code is required")
    private String courseCode;

    @NotBlank(message = "Course name is required")
    private String courseName;

    private String description;

    @Min(value = 1, message = "Credits must be at least 1")
    private Integer credits;

    private String department;

    private String instructor;

    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    private Integer enrolledStudents;

    private CourseStatus status;
}
