package com.awoniyitechnologies.exercisetracker.media;

import java.util.ArrayList;
import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.Routine;
import com.awoniyitechnologies.exercisetracker.models.RoutineExercise;
import com.awoniyitechnologies.exercisetracker.services.RoutineExerciseService;

import org.springframework.stereotype.Component;

@Component
public class RoutineResourceBuilder {

    private RoutineExerciseService routineExerciseService;
    private RoutineExerciseResourceBuilder routineExerciseResourceBuilder;

    public RoutineResourceBuilder(RoutineExerciseService routineExerciseService,
            RoutineExerciseResourceBuilder routineExerciseResourceBuilder) {
        this.routineExerciseService = routineExerciseService;
        this.routineExerciseResourceBuilder = routineExerciseResourceBuilder;
    }
    
    public RoutineResource toResource(Routine routine) {
        RoutineResource resource = new RoutineResource();

        
        resource.setUser_id(routine.getUser().getUser_id());
        resource.setRoutine_id(routine.getRoutine_id());
        resource.setIs_public(routine.getIs_public());
        resource.setName(routine.getName());
        resource.setDescription(routine.getDescription());
        resource.setCreated_at(routine.getCreated_at());

        List<RoutineExercise> routineExercises = routineExerciseService.getAllExercisesForRoutine(routine);
        List<RoutineExerciseResource> exercises = new ArrayList<RoutineExerciseResource>();
        for (RoutineExercise routineExercise : routineExercises) {
            exercises.add(routineExerciseResourceBuilder.toResource(routineExercise));
        }
        resource.setExercises(exercises);

        return resource;
    }
}
