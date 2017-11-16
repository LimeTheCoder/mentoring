package com.limethecoder.controller;

import com.limethecoder.model.StudentProfile;
import com.limethecoder.service.ClassManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassManagementController {
    private ClassManagementService classManagementService;

    @Autowired
    private ClassManagementController(ClassManagementService classManagementService) {
        this.classManagementService = classManagementService;
    }

    @GetMapping(path = "/{classId}/students")
    public List<StudentProfile> getStudentsInClass(@PathVariable Long classId) {
        return classManagementService.findStudentsInClass(classId);
    }

    @PostMapping(path = "/{classId}/students/{studentKey}")
    public void addStudentToClass(@PathVariable Long classId, @PathVariable String studentKey) {
        classManagementService.addStudentToSchoolClass(classId, studentKey);
    }
}
