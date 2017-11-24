package com.limethecoder.controller;

import com.limethecoder.exception.NotFoundException;
import com.limethecoder.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.limethecoder.service.CourseService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(path = "/{key}")
    public Course getCourseByKey(@PathVariable String key) {
        return courseService.findCourseByKey(key).orElseThrow(NotFoundException::new);
    }

    @GetMapping(path = "/search")
    public Course getCourseByName(@RequestParam(required = false) String name) {
        return courseService.findCourseByName(name).orElseThrow(NotFoundException::new);
    }

    @GetMapping
    public List<Course> findAllCourses(@RequestParam(defaultValue = "5", required = false) int limit) {
        return courseService.findAllCourses(limit);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody @Valid Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping(path = "/{key}")
    public Course updateCourse(@PathVariable String key,
                               @RequestBody @Valid Course course) {
        return courseService.updateCourse(key, course);
    }
}
