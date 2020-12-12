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
    private ExerciseService exerciseService;

    @Autowired
    public RoutineService(RoutineRepository routineRepository, RoutineExerciseService routineExerciseService,
            ExerciseService exerciseService) {
        this.routineRepository = routineRepository;
        this.routineExerciseService = routineExerciseService;
        this.exerciseService =exerciseService;
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

    public RoutineExercise createRoutineExercise(Long routine_id, Long exercise_id, RoutineExercise routineExercise) {
        routineExercise.setRoutine(getRoutine(routine_id));
        routineExercise.setExercise(exerciseService.getExercise(exercise_id));
        return routineExerciseService.createRoutineExercise(routineExercise);
    }
}
