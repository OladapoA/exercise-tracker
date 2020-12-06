package com.awoniyitechnologies.exercisetracker.models;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "routine_exercises")
public class RoutineExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routine_exercise_id;
    private Long routine_id;
    private Long exercise_id;
    private Integer sets;
    private Time set_break;
    private Integer  reps;
    private Time rep_break;
    private Time time;

    public Long getRoutine_exercise_id() {
        return routine_exercise_id;
    }

    public void setRoutine_exercise_id(Long routine_exercise_id) {
        this.routine_exercise_id = routine_exercise_id;
    }

    public Long getRoutine_id() {
        return routine_id;
    }

    public void setRoutine_id(Long routine_id) {
        this.routine_id = routine_id;
    }

    public Long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Long exercise_id) {
        this.exercise_id = exercise_id;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Time getSet_break() {
        return set_break;
    }

    public void setSet_break(Time set_break) {
        this.set_break = set_break;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Time getRep_break() {
        return rep_break;
    }

    public void setRep_break(Time rep_break) {
        this.rep_break = rep_break;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
