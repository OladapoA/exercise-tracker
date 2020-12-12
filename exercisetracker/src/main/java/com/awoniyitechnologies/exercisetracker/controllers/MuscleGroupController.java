package com.awoniyitechnologies.exercisetracker.controllers;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.MuscleGroup;
import com.awoniyitechnologies.exercisetracker.services.MuscleGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/muscle_groups")
public class MuscleGroupController {
    
    private MuscleGroupService muscleGroupService;

    @Autowired
    public MuscleGroupController(MuscleGroupService muscleGroupService){
        this.muscleGroupService = muscleGroupService;
    }

    @GetMapping
    public List<MuscleGroup> getAllMuscleGroup(){
        return muscleGroupService.getAllMuscleGroups();
    }
    
}
