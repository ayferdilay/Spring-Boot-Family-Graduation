package com.example.demo;

import com.example.demo.model.Education;
import com.example.demo.model.FamilyMember;
import com.example.demo.model.School;
import com.example.demo.service.EducationService;
import com.example.demo.service.FamilyMemberService;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
public class UnitOfWork {

    @Autowired
    private FamilyMemberService familyMemberService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private EducationService educationService;

    @Transactional
    public FamilyMember addFamilyMember(FamilyMember familyMember) {
        return familyMemberService.addFamilyMember(familyMember);
    }

    @Transactional
    public School addSchool(School school) {
        return schoolService.addSchool(school);
    }

    @Transactional
    public Education addEducation(Education education) {
        return educationService.addEducation(education);
    }

    @Transactional
    public void deleteFamilyMember(Long id) {
        familyMemberService.deleteFamilyMember(id);
    }

    @Transactional
    public void deleteSchool(Long id) {
        schoolService.deleteSchool(id);
    }

    @Transactional
    public void deleteEducation(Long id) {
        educationService.deleteEducation(id);
    }

    @Transactional(readOnly = true)
    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberService.getAllFamilyMembers();
    }

    @Transactional(readOnly = true)
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @Transactional(readOnly = true)
    public List<Education> getAllEducations() {
        return educationService.getAllEducations();
    }

    @Transactional(readOnly = true)
    public List<Education> getEducationsByFamilyMember(Long familyMemberId) {
        return educationService.getEducationsByFamilyMember(familyMemberId);
    }
}