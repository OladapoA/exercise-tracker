package com.awoniyitechnologies.exercisetracker.services;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.Routine;
import com.awoniyitechnologies.exercisetracker.models.RoutineExercise;
import com.awoniyitechnologies.exercisetracker.repositories.RoutineExerciseRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoutineExerciseService {
    
    private RoutineExerciseRepository routineExerciseRepository;

    @Autowired
    public RoutineExerciseService(RoutineExerciseRepository routineExerciseRepository) {
        this.routineExerciseRepository = routineExerciseRepository;
    }

    public List<RoutineExercise> getAllRoutineExercises() {
        return routineExerciseRepository.findAll();
    }

    public RoutineExercise getRoutineExercise(Long id) {
        return routineExerciseRepository.getOne(id);
    }

    public List<RoutineExercise> getAllExercisesForRoutine(Routine routine) {
        return routineExerciseRepository.findByRoutine(routine);
    }

    public RoutineExercise createRoutineExercise(RoutineExercise routineExercise) {
        return routineExerciseRepository.saveAndFlush(routineExercise);
    }

    public RoutineExercise updateRoutineExercise(Long id, RoutineExercise routineExercise) {
        RoutineExercise existingRoutineExercise = getRoutineExercise(id);
        BeanUtils.copyProperties(routineExercise, existingRoutineExercise, "routine_exercise_id", "routine", "exercise");
        return routineExerciseRepository.saveAndFlush(existingRoutineExercise);
    }

    public void deleteRoutineExercise(Long id) {
        routineExerciseRepository.deleteById(id);
    }
}
