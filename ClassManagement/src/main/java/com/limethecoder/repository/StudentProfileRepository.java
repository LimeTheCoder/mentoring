package com.limethecoder.repository;

import com.limethecoder.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, String> {
    @Query("select p from StudentProfile p where p.schoolClass.id = :schoolClassId")
    List<StudentProfile> findStudentProfilesInSchoolClass(@Param("schoolClassId") Long schoolClassId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE student_profile prfl SET prfl.class_id = :classId WHERE prfl.user_identificator = :studentKey", nativeQuery = true)
    void addStudentToClass(@Param("studentKey") String studentKey, @Param("classId") long classId);
}
