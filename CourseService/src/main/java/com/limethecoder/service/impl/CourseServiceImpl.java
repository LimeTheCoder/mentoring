package com.limethecoder.service.impl;

import com.limethecoder.exception.AlreadyExistsException;
import com.limethecoder.exception.InvalidRequestException;
import com.limethecoder.exception.NotFoundException;
import com.limethecoder.model.Course;
import com.limethecoder.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.limethecoder.repository.CourseRepository;
import com.limethecoder.service.CourseService;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private static final String EMPTY_COURSE_NAME_MSG = "Name of the course should be specified";
    private static final String COURSE_ALREADY_EXISTS = "Course with such name already exists";

    private static final int MAX_LIMIT = 50;
    private static final int DEFAULT_LIMIT = 5;

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<Course> findCourseByKey(String key) {
        return Optional.ofNullable(courseRepository.findOne(key));
    }

    @Override
    public Optional<Course> findCourseByName(String name) {
        return Optional.ofNullable(courseRepository.findCourseByName(name));
    }

    @Override
    public List<Course> findAllCourses(int limit) {
        int coursesLimit = isLimitValid(limit) ? limit : DEFAULT_LIMIT;
        return courseRepository.findAll(new PageRequest(0, coursesLimit)).getContent();
    }

    private boolean isLimitValid(int limit) {
        return limit > 0 && limit <= MAX_LIMIT;
    }

    @Override
    public Course createCourse(Course course) {
        validateCourseForCreation(course);
        return courseRepository.insert(course);
    }

    private void validateCourseForCreation(Course course) {
        if (StringUtils.isEmpty(course.getName())) {
            throw new InvalidRequestException(EMPTY_COURSE_NAME_MSG);
        }

        if (course.getId() != null) {
            throw new InvalidRequestException();
        }

        if (courseRepository.findCourseByName(course.getName()) != null) {
            throw new AlreadyExistsException(COURSE_ALREADY_EXISTS);
        }
    }

    @Override
    public Course updateCourse(String key, Course courseData) {
        if (StringUtils.isEmpty(key)) {
            throw new InvalidRequestException();
        }

        return Optional.ofNullable(courseRepository.findOne(key))
                .map(course -> {
                    populateCourse(course, courseData);
                    return courseRepository.save(course);
                }).orElseThrow(NotFoundException::new);
    }

    private void populateCourse(Course to, Course from) {
        to.setName(from.getName());
        to.setTeachers(from.getTeachers());
        to.setTopics(from.getTopics());
    }
}
