package com.example.userrecordmanagement.user;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="app_user")
public class User {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String about;
    private String roles;
    @ElementCollection
    @CollectionTable(name = "user_language", joinColumns = @JoinColumn(name = "userId"))
    @Column(name = "language")
    private List<String> language;
    @ElementCollection
    @CollectionTable(name = "user_skills", joinColumns = @JoinColumn(name = "userId"))
    @Column(name = "skill")
    private List<String> skills;
    @ElementCollection
    @CollectionTable(name = "user_p&E", joinColumns = @JoinColumn(name = "userId"))
    @Column(name = "projectsAndExperiences")
    private List<String> projectsAndExperiences;
    @ElementCollection
    @CollectionTable(name = "user_assignments", joinColumns = @JoinColumn(name = "userId"))
    @Column(name = "assignments")
    private List<String> assignments;
    private String pfp;
    
    public User() {
    }

    public User(String firstName, 
                String lastName, 
                String email, 
                String about, 
                String roles, 
                List<String> language,
                List<String> skills, 
                List<String> projectsAndExperiences, 
                List<String> assignments, 
                String pfp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.about = about;
        this.roles = roles;
        this.language = language;
        this.skills = skills;
        this.projectsAndExperiences = projectsAndExperiences;
        this.assignments = assignments;
        this.pfp = pfp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getProjectsAndExperiences() {
        return projectsAndExperiences;
    }

    public void setProjectsAndExperiences(List<String> projectsAndExperiences) {
        this.projectsAndExperiences = projectsAndExperiences;
    }

    public List<String> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<String> assignments) {
        this.assignments = assignments;
    }

    public String getPfp() {
        return pfp;
    }

    public void setPfp(String pfp) {
        this.pfp = pfp;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", about=" + about + ", roles=" + roles + ", language=" + language + ", skills=" + skills
                + ", projectsAndExperiences=" + projectsAndExperiences + ", assignments=" + assignments + ", pfp=" + pfp
                + "]";
    }

    
    
}