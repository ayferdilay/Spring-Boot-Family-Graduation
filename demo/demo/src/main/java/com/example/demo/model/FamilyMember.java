package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name ="family_member")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private FamilyMember parent;

    public FamilyMember() {
        // Boş constructor
    }

    public FamilyMember(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FamilyMember getParent() {
        return parent;
    }

    public void setParent(FamilyMember parent) {
        this.parent = parent;
    }

}
