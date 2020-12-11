package com.awoniyitechnologies.exercisetracker.controllers;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.media.RoutineResource;
import com.awoniyitechnologies.exercisetracker.media.RoutineResourceBuilder;
import com.awoniyitechnologies.exercisetracker.models.Routine;
import com.awoniyitechnologies.exercisetracker.models.RoutineExercise;
import com.awoniyitechnologies.exercisetracker.services.RoutineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/routines")
public class RoutineController {
    
    private RoutineService routineService;
    private RoutineResourceBuilder routineResourceBuilder;

    @Autowired
    public RoutineController(RoutineService routineService, RoutineResourceBuilder routineResourceBuilder) {
        this.routineService = routineService;
        this.routineResourceBuilder = routineResourceBuilder;
    }
    
    @GetMapping
    public List<Routine> getAllRoutines() {
        return routineService.getAllRoutines();
    }

    // @GetMapping
    // @RequestMapping("{id}")
    // public Routine getRoutine(@PathVariable Long id) {
    //     return routineService.getRoutine(id);
    // }

    @GetMapping
    @RequestMapping("{id}")
    public RoutineResource getRoutine(@PathVariable Long id) {
        Routine routine = routineService.getRoutine(id);
        return routineResourceBuilder.toResource(routine);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public Routine updateRoutine(@PathVariable Long id, @RequestBody Routine routine) {
        return routineService.updateRoutine(id, routine);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteRoutine(@PathVariable Long id) {
        routineService.deleteRoutine(id);
    }

    @GetMapping
    @RequestMapping("{id}/routine_exercises")
    public List<RoutineExercise> getAllExercisesForRoutine(@PathVariable Long id) {
        return routineService.getAllExercisesForRoutine(id);
    }

    // @PostMapping
    // @RequestMapping("{id}/routine_exercises")
    // public RoutineExercise createRoutineExercise(@PathVariable Long id, @RequestBody RoutineExercise routineExercise) {
    //     return routineService.createRoutineExercise(id);
    // }
}
