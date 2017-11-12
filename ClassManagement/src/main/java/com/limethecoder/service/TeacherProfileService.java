package com.limethecoder.service;

import com.limethecoder.model.TeacherProfile;

import java.util.List;

public interface TeacherProfileService {
    List<TeacherProfile> findAll(int limit);
    TeacherProfile findTeacherByKey(String key);
    TeacherProfile createTeacherProfile(TeacherProfile studentProfile);
    TeacherProfile updateTeacherProfile(String key, TeacherProfile studentProfile);
}
