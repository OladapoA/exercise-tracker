package com.awoniyitechnologies.exercisetracker.services;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.Exercise;
import com.awoniyitechnologies.exercisetracker.models.User;
import com.awoniyitechnologies.exercisetracker.repositories.ExerciseRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExerciseService {
    
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
    
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise createUserExercise(Exercise exercise) {
        return exerciseRepository.saveAndFlush(exercise);
    }

    public List<Exercise> getUserExercises(User user) {
        return exerciseRepository.findByUser(user);
    }

    public Exercise getExercise(Long id) {
        return exerciseRepository.getOne(id);
    }

    public Exercise updateExercise(Long id, Exercise exercise) {
        Exercise existingExercise = exerciseRepository.getOne(id);
        BeanUtils.copyProperties(exercise, existingExercise, "exercise_id", "user");
        return exerciseRepository.saveAndFlush(existingExercise);
    }

    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }

    public List<Exercise> getExerciseVariations(Long id) {
        Exercise exercise = getExercise(id);
        return exerciseRepository.findByParent(exercise);
    }

    public Exercise createExerciseVariation(Long exercise_id, Exercise exercise) {
        exercise.setParent(getExercise(exercise_id));
        return exerciseRepository.saveAndFlush(exercise);
    }

}
