package com.awoniyitechnologies.exercisetracker.controllers;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.Routine;
import com.awoniyitechnologies.exercisetracker.services.RoutineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/routines")
public class RoutineController {
    
    private RoutineService routineService;

    @Autowired
    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }
    
    @GetMapping
    public List<Routine> getAllRoutines() {
        return routineService.getAllRoutines();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Routine getRoutine(@PathVariable Long id) {
        return routineService.getRoutine(id);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public Routine updateRoutine(@PathVariable Long id, @RequestBody Routine routine) {
        return routineService.updateRoutine(id, routine);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteRoutine(@PathVariable Long id) {
        routineService.deleteRoutine(id);
    }
}
