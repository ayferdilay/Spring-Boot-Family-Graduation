package com.example.demo.service;

import com.example.demo.model.FamilyMember;
import com.example.demo.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyMemberService {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    public FamilyMember addFamilyMember(FamilyMember familyMember) {
        if (familyMember.getParent() != null && familyMember.getParent().getId() != null) {
            Optional<FamilyMember> parentOptional = familyMemberRepository.findById(familyMember.getParent().getId());
            parentOptional.ifPresent(familyMember::setParent);
        }
        return familyMemberRepository.save(familyMember);
    }

    public FamilyMember getFamilyMemberById(Long id) {
        return familyMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Family Member Id: " + id));
    }

    public FamilyMember updateFamilyMember(Long id, FamilyMember newFamilyMember) {
        FamilyMember existingFamilyMember = getFamilyMemberById(id);
        existingFamilyMember.setName(newFamilyMember.getName());
        return familyMemberRepository.save(existingFamilyMember);
    }

    public void deleteFamilyMember(Long id) {
        familyMemberRepository.deleteById(id);
    }

    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberRepository.findAll();
    }
}
