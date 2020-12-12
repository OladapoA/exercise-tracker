package com.awoniyitechnologies.exercisetracker.controllers;

import java.util.List;

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

    @Autowired
    public UserController(UserService userService, UserResourceBuilder userResourceBuilder) {
        this.userService = userService;
        this.userResourceBuilder = userResourceBuilder;
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // @GetMapping
    // @RequestMapping("{id}")
    // public User getUser(@PathVariable Long id) {
    //     return userService.getUser(id);
    // }

    @GetMapping
    @RequestMapping("{id}")
    public UserResource getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        UserResource userResource = userResourceBuilder.toResource(user);
        return userResource;
    }

    // @GetMapping
    // @RequestMapping("{id}")
    // public void getUser(@PathVariable Long id) {
    //     User user = userService.getUser(id);
    //     userResourceBuilder.toResource(user);
    //     // UserResource userResource = userResourceBuilder.toResource(user);
    //     // System.out.print(userResource);
    // }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    @GetMapping
    @RequestMapping(path = "{id}/routines")
    public List<Routine> getUserRoutines(@PathVariable Long id) {
        return userService.getUserRoutines(id);
    }

    @RequestMapping(path = "{id}/routines", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Routine createUserRoutine(@PathVariable Long id, @RequestBody Routine routine) {
        return userService.createUserRoutine(id, routine);
    }

    @GetMapping
    @RequestMapping(path = "{id}/exercises")
    public List<Exercise> getUserExercises(@PathVariable Long id) {
        return userService.getUserExercises(id);
    }

    @RequestMapping(path = "{id}/exercises", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Exercise createUserExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        System.out.print("create");
        return userService.createUserExercise(id, exercise);
    }

    @RequestMapping(path = "{user_id}/exercises/{exercise_id}/variations", method = RequestMethod.POST)
    public Exercise createExerciseVariation(@PathVariable Long user_id, @PathVariable Long exercise_id, @RequestBody Exercise exercise) {
        return userService.createExerciseVariation(user_id, exercise_id, exercise);
    }

}
