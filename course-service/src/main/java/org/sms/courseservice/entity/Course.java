package org.sms.courseservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "courses_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course code is required")
    @Column(nullable = false, unique = true)
    private String courseCode;

    @NotBlank(message = "Course name is required")
    @Column(nullable = false)
    private String courseName;

    @Column(length = 1000)
    private String description;

    @Min(value = 1, message = "Credits must be at least 1")
    private Integer credits;

    private String department;

    private String instructor;

    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    private Integer enrolledStudents = 0;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) {
            status = CourseStatus.ACTIVE;
        }
        if (enrolledStudents == null) {
            enrolledStudents = 0;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}