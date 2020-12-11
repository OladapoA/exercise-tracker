package com.awoniyitechnologies.exercisetracker.media;

import java.sql.Time;

public class RoutineExerciseResource {
    
    private Long routine_exercise_id;
    private ExerciseResource exercise;
    private Integer sets;
    private Time set_break;
    private Integer  reps;
    private Time rep_break;
    private Time time;

    public RoutineExerciseResource(){}

    public Long getRoutine_exercise_id() { return routine_exercise_id; }
    public void setRoutine_exercise_id(Long routine_exercise_id) { this.routine_exercise_id = routine_exercise_id; }

    public ExerciseResource getExercise() { return exercise; }
    public void setExercise(ExerciseResource exercise) { this.exercise = exercise; }

    public Integer getSets() { return sets; }
    public void setSets(Integer sets) { this.sets = sets; }

    public Time getSet_break() { return set_break; }
    public void setSet_break(Time set_break) { this.set_break = set_break; }

    public Integer getReps() { return reps; }
    public void setReps(Integer reps) { this.reps = reps; }

    public Time getRep_break() { return rep_break; }
    public void setRep_break(Time rep_break) { this.rep_break = rep_break; }

    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }
}
