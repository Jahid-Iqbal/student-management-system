package org.sms.courseservice.repo;

import org.sms.courseservice.entity.Course;
import org.sms.courseservice.entity.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {

    Optional<Course> findByCourseCode(String courseCode);

    List<Course> findByStatus(CourseStatus status);

    List<Course> findByDepartment(String department);

    List<Course> findByInstructor(String instructor);

    List<Course> findByCourseNameContainingIgnoreCase(String courseName);

    boolean existsByCourseCode(String courseCode);

    @Query("SELECT c FROM Course c WHERE c.enrolledStudents < c.capacity AND c.status = 'ACTIVE'")
    List<Course> findAvailableCourses();

    @Query("SELECT c FROM Course c WHERE c.department = ?1 AND c.status = 'ACTIVE'")
    List<Course> findActiveCoursesByDepartment(String department);
}
