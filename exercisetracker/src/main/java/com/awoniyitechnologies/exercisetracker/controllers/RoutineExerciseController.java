package com.awoniyitechnologies.exercisetracker.controllers;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.media.RoutineExerciseResource;
import com.awoniyitechnologies.exercisetracker.media.RoutineExerciseResourceBuilder;
import com.awoniyitechnologies.exercisetracker.models.RoutineExercise;
import com.awoniyitechnologies.exercisetracker.services.RoutineExerciseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/routine_exercises")
public class RoutineExerciseController {

    private RoutineExerciseService routineExerciseService;
    private RoutineExerciseResourceBuilder routineExerciseResourceBuilder;

    @Autowired
    public RoutineExerciseController(RoutineExerciseService routineExerciseService,
            RoutineExerciseResourceBuilder routineExerciseResourceBuilder) {
        this.routineExerciseService = routineExerciseService;
        this.routineExerciseResourceBuilder = routineExerciseResourceBuilder;
    }

    @GetMapping
    public List<RoutineExerciseResource> getAllRoutineExercises() {
        List<RoutineExercise> routineExercises = routineExerciseService.getAllRoutineExercises();
        return routineExerciseResourceBuilder.toResource(routineExercises);
    }

    // @GetMapping
    // @RequestMapping("{id}")
    // public RoutineExercise getRoutineExercise(@PathVariable Long id) {
    //     return routineExerciseService.getRoutineExercise(id);
    // }

    @GetMapping
    @RequestMapping("{id}")
    public RoutineExerciseResource getRoutineExercise(@PathVariable Long id) {
        RoutineExercise routineExercise = routineExerciseService.getRoutineExercise(id);
        return routineExerciseResourceBuilder.toResource(routineExercise);
    }
}
