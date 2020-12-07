package com.awoniyitechnologies.exercisetracker.services;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.Exercise;
import com.awoniyitechnologies.exercisetracker.models.Routine;
import com.awoniyitechnologies.exercisetracker.models.User;
import com.awoniyitechnologies.exercisetracker.repositories.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    
    private RoutineService routineService;
    private ExerciseService exerciseService;
    private UserRepository userRepository;

    @Autowired
    public UserService(RoutineService routineService, UserRepository userRepository, ExerciseService exerciseService) {
        this.routineService = routineService;
        this.exerciseService = exerciseService;
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.getOne(id);
    }

    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.getOne(id);
        BeanUtils.copyProperties(user, existingUser, "user_id", "excerises");
        return userRepository.saveAndFlush(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<Routine> getUserRoutines(Long id) {
        User user = userRepository.getOne(id);
        return routineService.getUserRoutines(user);
    }

    public Routine createUserRoutine(Long id, Routine routine) {
        User user = getUser(id);
        routine.setUser(user);
        return routineService.createUserRoutine(routine);
    }

    public List<Exercise> getUserExercises(Long id) {
        User user = getUser(id);
        return exerciseService.getUserExercises(user);
    }

    public Exercise createUserExercise(Long id, Exercise exercise) {
        exercise.setUser(getUser(id));
        return exerciseService.createUserExercise(exercise);
    }

    public Exercise createExerciseVariation(Long user_id, Long exercise_id, Exercise exercise) {
        exercise.setUser(getUser(user_id));
        return exerciseService.createExerciseVariation(exercise_id, exercise);
    }
}
