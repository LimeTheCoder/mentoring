package com.limethecoder.repository;

import com.limethecoder.model.CourseSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSessionRepository extends JpaRepository<CourseSession, Integer> {
    List<CourseSession> findByCourseKey(String courseKey);
    List<CourseSession> findBySchoolClassId(long classId);
    CourseSession findByCourseKeyAndSchoolClassId(String courseKey, long classId);
}
