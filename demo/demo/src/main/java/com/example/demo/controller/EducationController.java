package com.example.demo.controller;

import com.example.demo.model.Education;
import com.example.demo.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @PostMapping
    public ResponseEntity<Education> addEducation(@RequestBody Education education) {
        Education newEducation = educationService.addEducation(education);
        return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable("id") Long id) {
        Education education = educationService.getEducationById(id);
        return new ResponseEntity<>(education, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable("id") Long id, @RequestBody Education education) {
        Education updatedEducation = educationService.updateEducation(id, education);
        return new ResponseEntity<>(updatedEducation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable("id") Long id) {
        educationService.deleteEducation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Education>> getAllEducations() {
        List<Education> educations = educationService.getAllEducations();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }

    @GetMapping("/family-member/{familyMemberId}")
    public ResponseEntity<List<Education>> getEducationsByFamilyMember(@PathVariable("familyMemberId") Long familyMemberId) {
        List<Education> educations = educationService.getEducationsByFamilyMember(familyMemberId);
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }
}
