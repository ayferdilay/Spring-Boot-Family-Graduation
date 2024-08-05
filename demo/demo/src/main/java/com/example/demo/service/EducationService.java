package com.example.demo.service;

import com.example.demo.model.Education;
import com.example.demo.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public Education addEducation(Education education) {
        return educationRepository.save(education);
    }

    public Education getEducationById(Long id) {
        return educationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Education Id: " + id));
    }

    public Education updateEducation(Long id, Education newEducation) {
        Education existingEducation = getEducationById(id);
        existingEducation.setFamilyMember(newEducation.getFamilyMember());
        existingEducation.setSchool(newEducation.getSchool());
        existingEducation.setStartDate(newEducation.getStartDate());
        existingEducation.setGraduationDate(newEducation.getGraduationDate());
        return educationRepository.save(existingEducation);
    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    public List<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    public List<Education> getEducationsByFamilyMember(Long familyMemberId) {
        return educationRepository.findByFamilyMemberId(familyMemberId);
    }
}
