package com.awoniyitechnologies.exercisetracker.media;

import java.util.ArrayList;
import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.RoutineExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoutineExerciseResourceBuilder {

    private ExerciseResourceBuilder exerciseResourceBuilder;

    @Autowired
    public RoutineExerciseResourceBuilder(ExerciseResourceBuilder exerciseResourceBuilder){
        this.exerciseResourceBuilder = exerciseResourceBuilder;
    }

    public RoutineExerciseResource toResource(RoutineExercise routineExercise){
        RoutineExerciseResource resource = new RoutineExerciseResource();

        resource.setRoutine_exercise_id(routineExercise.getRoutine_exercise_id());
        ExerciseResource exercise = exerciseResourceBuilder.toResource(routineExercise.getExercise());
        resource.setExercise(exercise);
        resource.setSets(routineExercise.getSets());
        resource.setSet_break(routineExercise.getSet_break());
        resource.setReps(routineExercise.getReps());
        resource.setRep_break(routineExercise.getRep_break());
        resource.setTime(routineExercise.getTime());

        return resource;
    }

    public List<RoutineExerciseResource> toResource(List<RoutineExercise> routineExercises){
        List<RoutineExerciseResource> resource = new ArrayList<RoutineExerciseResource>();
        for (RoutineExercise routineExercise : routineExercises) {
            resource.add(this.toResource(routineExercise));
        }
        return resource;
    }
 
}
