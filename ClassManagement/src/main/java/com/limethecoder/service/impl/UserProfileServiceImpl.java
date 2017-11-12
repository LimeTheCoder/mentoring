package com.limethecoder.service.impl;

import com.limethecoder.repository.UserProfileRepository;
import com.limethecoder.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private static final Logger log = LoggerFactory.getLogger(UserProfileServiceImpl.class);
    private UserProfileRepository userProfileRepository;

    private UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void deleteProfile(String key) {
        try {
            userProfileRepository.delete(key);
            log.info(String.format("User profile with key: %s was delete successfully", key));
        } catch (EmptyResultDataAccessException e) {
            log.info(String.format("User profile with key: %s already was deleted", key));
        }
    }
}
