package com.limethecoder.service;

import com.limethecoder.model.StudentProfile;

import java.util.List;
import java.util.Optional;

public interface StudentProfileService {
    List<StudentProfile> findAll(int limit);
    Optional<StudentProfile> findByStudentId(String id);
    StudentProfile createStudentProfile(StudentProfile studentProfile);
}
