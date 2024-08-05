package com.example.demo.controller;

import com.example.demo.model.FamilyMember;
import com.example.demo.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family-members")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberService familyMemberService;

    @PostMapping
    public ResponseEntity<FamilyMember> addFamilyMember(@RequestBody FamilyMember familyMember) {
        FamilyMember newFamilyMember = familyMemberService.addFamilyMember(familyMember);
        return new ResponseEntity<>(newFamilyMember, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyMember> getFamilyMemberById(@PathVariable("id") Long id) {
        FamilyMember familyMember = familyMemberService.getFamilyMemberById(id);
        return new ResponseEntity<>(familyMember, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamilyMember> updateFamilyMember(@PathVariable("id") Long id, @RequestBody FamilyMember familyMember) {
        FamilyMember updatedFamilyMember = familyMemberService.updateFamilyMember(id, familyMember);
        return new ResponseEntity<>(updatedFamilyMember, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFamilyMember(@PathVariable("id") Long id) {
        familyMemberService.deleteFamilyMember(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<FamilyMember>> getAllFamilyMembers() {
        List<FamilyMember> familyMembers = familyMemberService.getAllFamilyMembers();
        return new ResponseEntity<>(familyMembers, HttpStatus.OK);
    }
}



