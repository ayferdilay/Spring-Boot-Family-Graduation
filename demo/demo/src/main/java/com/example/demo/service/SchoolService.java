package com.example.demo.service;

import com.example.demo.model.School;
import com.example.demo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid School Id: " + id));
    }

    public School updateSchool(Long id, School newSchool) {
        School existingSchool = getSchoolById(id);
        existingSchool.setName(newSchool.getName());
        existingSchool.setCity(newSchool.getCity());
        return schoolRepository.save(existingSchool);
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }
}
