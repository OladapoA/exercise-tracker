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
    public List<ExerciseResource> getAllExercices() {
        List<Exercise> exercises = exerciseService.getAllExercises();
        return exerciseResourceBuilder.toResource(exercises);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ExerciseResource getExercise(@PathVariable Long id) {
        Exercise exercise = exerciseService.getExercise(id);
        return exerciseResourceBuilder.toResource(exercise);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public ExerciseResource updateExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        Exercise updatedExercise = exerciseService.updateExercise(id, exercise);
        return exerciseResourceBuilder.toResource(updatedExercise);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
    }

    @GetMapping
    @RequestMapping("{id}/variations")
    public List<ExerciseResource> getExerciseVariations(@PathVariable Long id) {
        List<Exercise> exercises = exerciseService.getExerciseVariations(id);
        return exerciseResourceBuilder.toResource(exercises);
    }
}
