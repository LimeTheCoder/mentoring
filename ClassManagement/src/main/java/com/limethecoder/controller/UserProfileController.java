package com.limethecoder.controller;

import com.limethecoder.exception.NotFoundException;
import com.limethecoder.model.StudentProfile;
import com.limethecoder.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
    private StudentProfileService studentProfileService;

    @Autowired
    public UserProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @GetMapping(path = "/student/all")
    public List<StudentProfile> getAllStudents(@RequestParam(defaultValue = "5", required = false) int limit) {
        return studentProfileService.findAll(limit);
    }

    @GetMapping(path = "/student")
    public StudentProfile getStudentById(@RequestParam(name = "key") String studentId) {
        return studentProfileService.findByStudentId(studentId).orElseThrow(NotFoundException::new);
    }

    @PostMapping(path = "/student")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentProfile createStudentProfile(@RequestBody StudentProfile profile) {
        return studentProfileService.createStudentProfile(profile);
    }
}
