package com.limethecoder.service.impl;

import com.limethecoder.converter.UserProfileConverter;
import com.limethecoder.exception.AlreadyExistsException;
import com.limethecoder.exception.NotFoundException;
import com.limethecoder.model.StudentProfile;
import com.limethecoder.repository.StudentProfileRepository;
import com.limethecoder.repository.UserProfileRepository;
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
    private UserProfileRepository userProfileRepository;

    @Autowired
    private StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository,
                                      UserProfileRepository userProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
        this.userProfileRepository = userProfileRepository;
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
    public StudentProfile findStudentByKey(String key) {
        return Optional.ofNullable(studentProfileRepository.findOne(key)).orElseThrow(NotFoundException::new);
    }

    @Override
    public StudentProfile createStudentProfile(StudentProfile studentProfile) {
        if (isUserProfileAlreadyExists(studentProfile.getKey())) {
            throw new AlreadyExistsException();
        }

        return studentProfileRepository.save(studentProfile);
    }

    private boolean isUserProfileAlreadyExists(String key) {
        return !StringUtils.isEmpty(key) && userProfileRepository.exists(key);
    }

    @Override
    public StudentProfile updateStudentProfile(String id, StudentProfile data) {
        return Optional.ofNullable(studentProfileRepository.findOne(id))
                .map(profile -> {
                    UserProfileConverter.populateStudentProfile(profile, data);
                    return studentProfileRepository.save(profile);
                })
                .orElseThrow(NotFoundException::new);
    }
}
