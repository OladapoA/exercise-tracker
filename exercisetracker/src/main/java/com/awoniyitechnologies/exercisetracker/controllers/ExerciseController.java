package com.awoniyitechnologies.exercisetracker.controllers;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.media.ExerciseResource;
import com.awoniyitechnologies.exercisetracker.media.ExerciseResourceBuilder;
import com.awoniyitechnologies.exercisetracker.models.Exercise;
import com.awoniyitechnologies.exercisetracker.services.ExerciseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exercises")
public class ExerciseController {
    
    private ExerciseService exerciseService;
    private ExerciseResourceBuilder exerciseResourceBuilder;

    @Autowired
    public ExerciseController(ExerciseService exerciseService, ExerciseResourceBuilder exerciseResourceBuilder) {
        this.exerciseService = exerciseService;
        this.exerciseResourceBuilder = exerciseResourceBuilder;
    }

    @GetMapping
    public List<Exercise> getAllExercices() {
        return exerciseService.getAllExercises();
    }

    // @PostMapping
    // public Exercise createExercise(@RequestBody Exercise exercise) {
    //     return exerciseService.createExercise(exercise);
    // }

    // @GetMapping
    // @RequestMapping("{id}")
    // public Exercise getExercise(@PathVariable Long id) {
    //     return exerciseService.getExercise(id);
    // }

    @GetMapping
    @RequestMapping("{id}")
    public ExerciseResource getExercise(@PathVariable Long id) {
        Exercise exercise = exerciseService.getExercise(id);
        return exerciseResourceBuilder.toResource(exercise);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public Exercise updateExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        return exerciseService.updateExercise(id, exercise);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
    }

    @GetMapping
    @RequestMapping("{id}/variations")
    public List<Exercise> getExerciseVariations(@PathVariable Long id) {
        return exerciseService.getExerciseVariations(id);
    }

    // @RequestMapping(path = "{id}/variations", method = RequestMethod.POST)
    // public Exercise createExerciseVariation(@PathVariable Long id, @RequestBody Exercise exercise) {
    //     return exerciseService.createExerciseVariation(id, exercise);
    // }
}
