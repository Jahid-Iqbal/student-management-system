package org.sms.enrollmentservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sms.enrollmentservice.entity.EnrollmentStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDto {
    private Long id;

    @NotNull(message = "Student ID is required")
    private Long studentId;

    @NotNull(message = "Course ID is required")
    private Long courseId;

    @NotBlank(message = "Semester is required")
    private String semester;
    private EnrollmentStatus status;
    private LocalDateTime enrollmentDate;
    private LocalDateTime dropDate;
    private LocalDateTime completionDate;

    private StudentDto student;
    private CourseDto course;
}
