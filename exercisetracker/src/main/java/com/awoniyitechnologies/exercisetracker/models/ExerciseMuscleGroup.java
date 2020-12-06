package com.awoniyitechnologies.exercisetracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "exercise_muscle_groups")
public class ExerciseMuscleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercise_id;
    private Long muscle_group_id;

    public Long getExercise_id() { return exercise_id; }
    public void setExercise_id(Long exercise_id) { this.exercise_id = exercise_id; }

    public Long getMuscle_group_id() { return muscle_group_id; }
    public void setMuscle_group_id(Long muscle_group_id) { this.muscle_group_id = muscle_group_id; }
}
