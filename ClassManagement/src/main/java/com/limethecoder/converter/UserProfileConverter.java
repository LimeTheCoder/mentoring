package com.limethecoder.converter;

import com.limethecoder.model.StudentProfile;
import com.limethecoder.model.TeacherProfile;
import com.limethecoder.model.UserProfile;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserProfileConverter {
    public static void populateUserProfile(UserProfile profile, UserProfile data) {
        if (data == null) {
            return;
        }

        profile.setName(data.getName());
        profile.setSurname(data.getSurname());
        profile.setSecondName(data.getSecondName());
        profile.setAge(data.getAge());
        profile.setPhone(data.getPhone());
        profile.setAddress(AddressConverter.populateAddress(profile.getAddress(), data.getAddress()));
    }

    public static void populateStudentProfile(StudentProfile studentProfile, StudentProfile data) {
        populateUserProfile(studentProfile, data);
        studentProfile.setEnrollmentYear(data.getEnrollmentYear());
    }

    public static void populateTeacherProfile(TeacherProfile teacherProfile, TeacherProfile data) {
        populateUserProfile(teacherProfile, data);
        teacherProfile.setExperience(data.getExperience());
        teacherProfile.setPosition(data.getPosition());
        teacherProfile.setSubject(data.getSubject());
    }
}
