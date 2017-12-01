package com.limethecoder.controller;

import com.limethecoder.exception.NotFoundException;
import com.limethecoder.model.CourseSession;
import com.limethecoder.service.CourseSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/session")
public class CourseSessionController {
    private CourseSessionService courseSessionService;

    @Autowired
    public CourseSessionController(CourseSessionService courseSessionService) {
        this.courseSessionService = courseSessionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseSession createCourseSession(@RequestBody @Valid CourseSession courseSession) {
        return courseSessionService.createCourseSession(courseSession);
    }

    @GetMapping("/course/{courseKey}")
    public List<CourseSession> getSessionsForCourse(@PathVariable String courseKey) {
        return courseSessionService.findByCourseKey(courseKey);
    }

    @GetMapping("/search")
    public List<CourseSession> searchCourseSessions(@RequestParam(required = false) String courseKey,
                                                    @RequestParam(required = false) Integer classId) {
        if (courseKey != null && classId != null) {
            CourseSession session = courseSessionService.findByCourseKeyAndSchoolClassId(courseKey, classId)
                    .orElseThrow(NotFoundException::new);
            return Collections.singletonList(session);
        }

        if (courseKey != null) {
            return courseSessionService.findByCourseKey(courseKey);
        }

        if (classId != null) {
            return courseSessionService.findBySchoolClassId(classId);
        }

        return courseSessionService.findAllSessions();
    }
}
