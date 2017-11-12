package com.limethecoder.service.impl;

import com.limethecoder.converter.UserProfileConverter;
import com.limethecoder.exception.AlreadyExistsException;
import com.limethecoder.exception.NotFoundException;
import com.limethecoder.model.TeacherProfile;
import com.limethecoder.repository.TeacherProfileRepository;
import com.limethecoder.repository.UserProfileRepository;
import com.limethecoder.service.TeacherProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherProfileServiceImpl implements TeacherProfileService {
    private static final int MAX_LIMIT = 50;
    private static final int DEFAULT_LIMIT = 5;

    private TeacherProfileRepository teacherProfileRepository;
    private UserProfileRepository userProfileRepository;

    @Autowired
    private TeacherProfileServiceImpl(TeacherProfileRepository teacherProfileRepository,
                                      UserProfileRepository userProfileRepository) {
        this.teacherProfileRepository = teacherProfileRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public List<TeacherProfile> findAll(int limit) {
        int studentLimit = isLimitValid(limit) ? limit : DEFAULT_LIMIT;
        return teacherProfileRepository.findAll(new PageRequest(0, studentLimit)).getContent();
    }

    private boolean isLimitValid(int limit) {
        return limit > 0 && limit <= MAX_LIMIT;
    }

    @Override
    public TeacherProfile findTeacherByKey(String key) {
        return Optional.ofNullable(teacherProfileRepository.findOne(key)).orElseThrow(NotFoundException::new);
    }

    @Override
    public TeacherProfile createTeacherProfile(TeacherProfile teacherProfile) {
        if (isUserProfileAlreadyExists(teacherProfile.getKey())) {
            throw new AlreadyExistsException();
        }

        return teacherProfileRepository.save(teacherProfile);
    }

    private boolean isUserProfileAlreadyExists(String key) {
        return !StringUtils.isEmpty(key) && userProfileRepository.exists(key);
    }

    @Override
    public TeacherProfile updateTeacherProfile(String id, TeacherProfile data) {
        return Optional.ofNullable(teacherProfileRepository.findOne(id))
                .map(profile -> {
                    UserProfileConverter.populateTeacherProfile(profile, data);
                    return teacherProfileRepository.save(profile);
                })
                .orElseThrow(NotFoundException::new);
    }
}
