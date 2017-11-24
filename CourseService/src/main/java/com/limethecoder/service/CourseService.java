package com.limethecoder.service;

import com.limethecoder.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<Course> findCourseByKey(String key);
    Optional<Course> findCourseByName(String name);
    List<Course> findAllCourses(int limit);
    Course createCourse(Course course);
    Course updateCourse(String key, Course courseData);
}
