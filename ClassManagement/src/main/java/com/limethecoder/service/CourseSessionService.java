package com.limethecoder.service;

import com.limethecoder.model.CourseSession;

import java.util.List;
import java.util.Optional;

public interface CourseSessionService {
    List<CourseSession> findByCourseKey(String courseKey);
    List<CourseSession> findBySchoolClassId(long classId);
    List<CourseSession> findAllSessions();
    Optional<CourseSession> findByCourseKeyAndSchoolClassId(String courseKey, long classId);
    CourseSession createCourseSession(CourseSession session);
}
