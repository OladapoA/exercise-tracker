package com.awoniyitechnologies.exercisetracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "exercises")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercise_id;
    
    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "variation_parent")
    private Exercise parent;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Long getExercise_id() { return exercise_id; }
    public void setExercise_id(Long exercise_id) { this.exercise_id = exercise_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Exercise getParent() { return parent; }
    public void setParent(Exercise parent) { this.parent = parent; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
}
