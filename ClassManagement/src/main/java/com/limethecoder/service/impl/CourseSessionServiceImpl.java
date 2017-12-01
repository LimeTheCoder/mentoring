package com.limethecoder.service.impl;

import com.limethecoder.exception.NotFoundException;
import com.limethecoder.model.CourseSession;
import com.limethecoder.repository.CourseSessionRepository;
import com.limethecoder.repository.SchoolClassRepository;
import com.limethecoder.service.CourseSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseSessionServiceImpl implements CourseSessionService {
    private CourseSessionRepository courseSessionRepository;
    private SchoolClassRepository schoolClassRepository;

    @Autowired
    public CourseSessionServiceImpl(CourseSessionRepository courseSessionRepository,
                                    SchoolClassRepository schoolClassRepository) {
        this.courseSessionRepository = courseSessionRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    @Override
    public List<CourseSession> findByCourseKey(String courseKey) {
        return courseSessionRepository.findByCourseKey(courseKey);
    }

    @Override
    public Optional<CourseSession> findByCourseKeyAndSchoolClassId(String courseKey, long classId) {
        return Optional.ofNullable(courseSessionRepository.findByCourseKeyAndSchoolClassId(courseKey, classId));
    }

    @Override
    public CourseSession createCourseSession(CourseSession session) {
        if (!schoolClassRepository.exists(session.getSchoolClassId())) {
            throw new NotFoundException("Class doesn't exists");
        }

        return courseSessionRepository.save(session);
    }

    @Override
    public List<CourseSession> findBySchoolClassId(long classId) {
        return courseSessionRepository.findBySchoolClassId(classId);
    }

    @Override
    public List<CourseSession> findAllSessions() {
        return courseSessionRepository.findAll();
    }
}
