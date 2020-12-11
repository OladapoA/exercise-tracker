package com.awoniyitechnologies.exercisetracker.services;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.Routine;
import com.awoniyitechnologies.exercisetracker.models.RoutineExercise;
import com.awoniyitechnologies.exercisetracker.models.User;
import com.awoniyitechnologies.exercisetracker.repositories.RoutineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoutineService {

    private RoutineRepository routineRepository;
    private RoutineExerciseService routineExerciseService;

    @Autowired
    public RoutineService(RoutineRepository routineRepository, RoutineExerciseService routineExerciseService) {
        this.routineRepository = routineRepository;
        this.routineExerciseService = routineExerciseService;
    }

    public List<Routine> getAllRoutines() {
        return routineRepository.findAll();
    }

    public Routine getRoutine(Long id) {
        return routineRepository.getOne(id);
    }

    public Routine createUserRoutine(Routine routine) {
        return routineRepository.saveAndFlush(routine);
    }

    public Routine updateRoutine(Long id, Routine routine) {
        Routine existingRoutine = routineRepository.getOne(id);
        existingRoutine.setIs_public(routine.getIs_public());
        existingRoutine.setName(routine.getName());
        existingRoutine.setDescription(routine.getDescription());
        return routineRepository.saveAndFlush(existingRoutine);
    }

    public void deleteRoutine(Long id) {
        routineRepository.deleteById(id);
    }

    public List<Routine> getUserRoutines(User user) {
        return routineRepository.findByUser(user);
    }

    public List<RoutineExercise> getAllExercisesForRoutine(Long id) {
        Routine routine = getRoutine(id);
        return routineExerciseService.getAllExercisesForRoutine(routine);
    }

    // public RoutineExercise createRoutineExercise(Long id, RoutineExercise routineExercise) {
    //     Routine routine = getRoutine(id);
    //     return routineExerciseService.createRoutineExercise(routineExercise);
    // }
}
