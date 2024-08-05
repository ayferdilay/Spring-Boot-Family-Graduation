package com.example.demo.controller;

import com.example.demo.model.School;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public ResponseEntity<School> addSchool(@RequestBody School school) {
        School newSchool = schoolService.addSchool(school);
        return new ResponseEntity<>(newSchool, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable("id") Long id) {
        School school = schoolService.getSchoolById(id);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable("id") Long id, @RequestBody School school) {
        School updatedSchool = schoolService.updateSchool(id, school);
        return new ResponseEntity<>(updatedSchool, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable("id") Long id) {
        schoolService.deleteSchool(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }
}

