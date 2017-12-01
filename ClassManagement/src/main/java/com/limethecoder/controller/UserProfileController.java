package com.limethecoder.controller;

import com.limethecoder.model.StudentProfile;
import com.limethecoder.model.TeacherProfile;
import com.limethecoder.service.StudentProfileService;
import com.limethecoder.service.TeacherProfileService;
import com.limethecoder.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
    private StudentProfileService studentProfileService;
    private UserProfileService userProfileService;
    private TeacherProfileService teacherProfileService;

    @Autowired
    public UserProfileController(StudentProfileService studentProfileService,
                                 UserProfileService userProfileService,
                                 TeacherProfileService teacherProfileService) {
        this.studentProfileService = studentProfileService;
        this.userProfileService = userProfileService;
        this.teacherProfileService = teacherProfileService;
    }

    @GetMapping(path = "/student")
    public List<StudentProfile> getAllStudents(@RequestParam(defaultValue = "5", required = false) int limit) {
        return studentProfileService.findAll(limit);
    }

    @GetMapping(path = "/student/{key}")
    public StudentProfile getStudentByKey(@PathVariable String key) {
        return studentProfileService.findStudentByKey(key);
    }

    @PostMapping(path = "/student")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentProfile createStudentProfile(@RequestBody @Valid StudentProfile profile) {
        return studentProfileService.createStudentProfile(profile);
    }

    @PutMapping(path = "/student/{key}")
    public StudentProfile updateStudentProfile(@PathVariable String key,
                                               @RequestBody @Valid StudentProfile profile) {
        return studentProfileService.updateStudentProfile(key, profile);
    }

    @DeleteMapping(path = {"/student/{key}", "/teacher/{key}"})
    public void deleteUserProfile(@PathVariable String key) {
        userProfileService.deleteProfile(key);
    }

    @GetMapping(path = "/teacher")
    public List<TeacherProfile> getAllTeachers(@RequestParam(defaultValue = "5", required = false) int limit) {
        return teacherProfileService.findAll(limit);
    }

    @GetMapping(path = "/teacher/{key}")
    public TeacherProfile getTeacherByKey(@PathVariable String key) {
        return teacherProfileService.findTeacherByKey(key);
    }

    @PostMapping(path = "/teacher")
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherProfile createTeacherProfile(@RequestBody @Valid TeacherProfile profile) {
        return teacherProfileService.createTeacherProfile(profile);
    }

    @PutMapping(path = "/teacher/{key}")
    public TeacherProfile updateTeacherProfile(@PathVariable String key,
                                               @RequestBody @Valid TeacherProfile profile) {
        return teacherProfileService.updateTeacherProfile(key, profile);
    }
}
