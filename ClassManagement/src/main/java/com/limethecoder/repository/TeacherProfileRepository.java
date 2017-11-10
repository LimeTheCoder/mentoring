package com.limethecoder.repository;

import com.limethecoder.model.TeacherProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherProfileRepository extends JpaRepository<TeacherProfile, String> {
}
