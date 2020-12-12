package com.awoniyitechnologies.exercisetracker.controllers;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.media.ExerciseResource;
import com.awoniyitechnologies.exercisetracker.media.ExerciseResourceBuilder;
import com.awoniyitechnologies.exercisetracker.media.RoutineResource;
import com.awoniyitechnologies.exercisetracker.media.RoutineResourceBuilder;
import com.awoniyitechnologies.exercisetracker.media.UserResource;
import com.awoniyitechnologies.exercisetracker.media.UserResourceBuilder;
import com.awoniyitechnologies.exercisetracker.models.Exercise;
import com.awoniyitechnologies.exercisetracker.models.Routine;
import com.awoniyitechnologies.exercisetracker.models.User;
import com.awoniyitechnologies.exercisetracker.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;
    private UserResourceBuilder userResourceBuilder;
    private RoutineResourceBuilder routineResourceBuilder;
    private ExerciseResourceBuilder exerciseResourceBuilder;

    @Autowired
    public UserController(UserService userService, UserResourceBuilder userResourceBuilder,
            RoutineResourceBuilder routineResourceBuilder, ExerciseResourceBuilder exerciseResourceBuilder) {
        this.userService = userService;
        this.userResourceBuilder = userResourceBuilder;
        this.routineResourceBuilder = routineResourceBuilder;
        this.exerciseResourceBuilder = exerciseResourceBuilder;
    }
    
    @GetMapping
    public List<UserResource> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return userResourceBuilder.toResource(users);
    }

    @GetMapping
    @RequestMapping("{id}")
    public UserResource getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return userResourceBuilder.toResource(user);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResource createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return userResourceBuilder.toResource(newUser);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public UserResource updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return userResourceBuilder.toResource(updatedUser);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    @GetMapping
    @RequestMapping(path = "{id}/routines")
    public List<RoutineResource> getUserRoutines(@PathVariable Long id) {
        List<Routine> routines = userService.getUserRoutines(id);
        return routineResourceBuilder.toResource(routines);
    }

    @RequestMapping(path = "{id}/routines", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public RoutineResource createUserRoutine(@PathVariable Long id, @RequestBody Routine routine) {
        Routine newRoutine = userService.createUserRoutine(id, routine);
        return routineResourceBuilder.toResource(newRoutine);
    }

    @GetMapping
    @RequestMapping(path = "{id}/exercises")
    public List<ExerciseResource> getUserExercises(@PathVariable Long id) {
        List<Exercise> exercises = userService.getUserExercises(id);
        return exerciseResourceBuilder.toResource(exercises);
    }

    @RequestMapping(path = "{id}/exercises", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ExerciseResource createUserExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        Exercise newExercise = userService.createUserExercise(id, exercise);
        return exerciseResourceBuilder.toResource(newExercise);
    }

    @RequestMapping(path = "{user_id}/exercises/{exercise_id}/variations", method = RequestMethod.POST)
    public ExerciseResource createExerciseVariation(@PathVariable Long user_id, @PathVariable Long exercise_id, @RequestBody Exercise exercise) {
        Exercise newExercise = userService.createExerciseVariation(user_id, exercise_id, exercise);
        return exerciseResourceBuilder.toResource(newExercise);
    }

}
