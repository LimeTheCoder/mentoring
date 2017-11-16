package com.limethecoder.service.impl;

import com.limethecoder.exception.NotFoundException;
import com.limethecoder.model.StudentProfile;
import com.limethecoder.repository.SchoolClassRepository;
import com.limethecoder.repository.StudentProfileRepository;
import com.limethecoder.service.ClassManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassManagementServiceImpl implements ClassManagementService {
    private SchoolClassRepository schoolClassRepository;
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private ClassManagementServiceImpl(SchoolClassRepository schoolClassRepository,
                                       StudentProfileRepository studentProfileRepository) {
        this.schoolClassRepository = schoolClassRepository;
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public void addStudentToSchoolClass(Long schoolClassId, String studentKey) {
        if (!isClassAndStudentProfileExist(schoolClassId, studentKey)) {
            throw new NotFoundException();
        }

        studentProfileRepository.addStudentToClass(studentKey, schoolClassId);
    }

    private boolean isClassAndStudentProfileExist(Long schoolClassId, String studentKey) {
        return schoolClassId != null
                && studentKey != null
                && schoolClassRepository.exists(schoolClassId)
                && studentProfileRepository.exists(studentKey);
    }

    @Override
    public List<StudentProfile> findStudentsInClass(Long schoolClassId) {
        if (schoolClassId == null || !schoolClassRepository.exists(schoolClassId)) {
            throw new NotFoundException();
        }

        return studentProfileRepository.findStudentProfilesInSchoolClass(schoolClassId);
    }
}
