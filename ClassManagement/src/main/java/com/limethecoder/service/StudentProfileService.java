package com.limethecoder.service;

import com.limethecoder.model.StudentProfile;

import java.util.List;
import java.util.Optional;

public interface StudentProfileService {
    List<StudentProfile> findAll(int limit);
    StudentProfile findStudentByKey(String key);
    StudentProfile createStudentProfile(StudentProfile studentProfile);
    StudentProfile updateStudentProfile(String key, StudentProfile studentProfile);
}
