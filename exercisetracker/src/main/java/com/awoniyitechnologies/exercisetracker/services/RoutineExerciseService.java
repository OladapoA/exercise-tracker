package com.awoniyitechnologies.exercisetracker.services;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.RoutineExercise;
import com.awoniyitechnologies.exercisetracker.repositories.RoutineExerciseRepository;

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
}
