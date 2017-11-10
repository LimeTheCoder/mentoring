package com.limethecoder.service.impl;

import com.limethecoder.exception.AlreadyExistsException;
import com.limethecoder.model.StudentProfile;
import com.limethecoder.repository.StudentProfileRepository;
import com.limethecoder.service.StudentProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {
    private static final int MAX_LIMIT = 50;
    private static final int DEFAULT_LIMIT = 5;

    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public List<StudentProfile> findAll(int limit) {
        int studentLimit = isLimitValid(limit) ? limit : DEFAULT_LIMIT;
        return studentProfileRepository.findAll(new PageRequest(0, studentLimit)).getContent();
    }

    private boolean isLimitValid(int limit) {
        return limit > 0 && limit <= MAX_LIMIT;
    }

    @Override
    public Optional<StudentProfile> findByStudentId(String id) {
        return Optional.ofNullable(studentProfileRepository.findOne(id));
    }

    @Override
    public StudentProfile createStudentProfile(StudentProfile studentProfile) {
        if (isStudentProfileExists(studentProfile)) {
            throw new AlreadyExistsException();
        }

        return studentProfileRepository.save(studentProfile);
    }

    private boolean isStudentProfileExists(StudentProfile studentProfile) {
        String studentId = studentProfile.getId();
        return !StringUtils.isEmpty(studentId) && studentProfileRepository.exists(studentId);
    }
}
