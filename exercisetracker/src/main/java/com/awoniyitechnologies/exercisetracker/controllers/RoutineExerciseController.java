package com.awoniyitechnologies.exercisetracker.controllers;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.RoutineExercise;
import com.awoniyitechnologies.exercisetracker.services.RoutineExerciseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/routine_exercises")
public class RoutineExerciseController {

    private RoutineExerciseService routineExerciseService;

    @Autowired
    public RoutineExerciseController(RoutineExerciseService routineExerciseService) {
        this.routineExerciseService = routineExerciseService;
    }

    @GetMapping
    public List<RoutineExercise> getAllRoutineExercises() {
        return routineExerciseService.getAllRoutineExercises();
    }
}
