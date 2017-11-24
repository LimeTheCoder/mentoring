package com.limethecoder.repository;

import com.limethecoder.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
    Course findCourseByName(String name);
}
