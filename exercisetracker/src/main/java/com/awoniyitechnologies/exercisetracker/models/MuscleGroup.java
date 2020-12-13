package com.awoniyitechnologies.exercisetracker.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "muscle_groups")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MuscleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long muscle_group_id;
    private String major_name;
    private String minor_name;

    @ManyToMany(mappedBy = "muscle_groups")
    private List<Exercise> exercises;

    public Long getMuscle_group_id() { return muscle_group_id; }
    public void setMuscle_group_id(Long muscle_group_id) { this.muscle_group_id = muscle_group_id; }

    public String getMajor_name() { return major_name; }
    public void setMajor_name(String major_name) { this.major_name = major_name; }

    public String getMinor_name() { return minor_name; }
    public void setMinor_name(String minor_name) { this.minor_name = minor_name; }

    public List<Exercise> getExercises() { return exercises; }
    public void setExercises(List<Exercise> exercises) { this.exercises = exercises; }
}
