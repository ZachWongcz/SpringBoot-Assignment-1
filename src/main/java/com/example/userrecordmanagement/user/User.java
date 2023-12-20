package com.example.userrecordmanagement.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String language;
    private String skills;
    private String projectsAndExperiences;
    private String assignments;
    private String pfp;
    
    public User() {
    }

    public User(String firstName, 
                String lastName, 
                String email, 
                String about, 
                String roles, 
                String language,
                String skills, 
                String projectsAndExperiences, 
                String assignments, 
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getProjectsAndExperiences() {
        return projectsAndExperiences;
    }

    public void setProjectsAndExperiences(String projectsAndExperiences) {
        this.projectsAndExperiences = projectsAndExperiences;
    }

    public String getAssignments() {
        return assignments;
    }

    public void setAssignments(String assignments) {
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