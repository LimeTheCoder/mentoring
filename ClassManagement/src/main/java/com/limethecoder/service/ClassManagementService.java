package com.limethecoder.service;

import com.limethecoder.model.StudentProfile;

import java.util.List;

public interface ClassManagementService {
    void addStudentToSchoolClass(Long schoolClassId, String studentKey);
    List<StudentProfile> findStudentsInClass(Long schoolClassId);
}
