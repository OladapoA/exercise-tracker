package com.awoniyitechnologies.exercisetracker.services;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.MuscleGroup;
import com.awoniyitechnologies.exercisetracker.repositories.MuscleGroupRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MuscleGroupService {

    MuscleGroupRepository muscleGroupRepository;
    
    public MuscleGroupService(MuscleGroupRepository muscleGroupRepository) {
        this.muscleGroupRepository = muscleGroupRepository;
    }

    public List<MuscleGroup> getAllMuscleGroups(){
        return muscleGroupRepository.findAll();
    }
    
}
