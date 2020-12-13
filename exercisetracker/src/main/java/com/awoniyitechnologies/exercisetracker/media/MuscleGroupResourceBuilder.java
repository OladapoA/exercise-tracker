package com.awoniyitechnologies.exercisetracker.media;

import java.util.ArrayList;
import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.MuscleGroup;

import org.springframework.stereotype.Component;

@Component
public class MuscleGroupResourceBuilder {

    public MuscleGroupResource toResource(MuscleGroup muscleGroup){
        MuscleGroupResource resource = new MuscleGroupResource();
        resource.setMuscle_group_id(muscleGroup.getMuscle_group_id());
        resource.setMajor_name(muscleGroup.getMajor_name());
        resource.setMinor_name(muscleGroup.getMinor_name());
        resource.setNo_of_exercises(muscleGroup.getExercises().size());

        return resource;
    }

    public List<MuscleGroupResource> toResource(List<MuscleGroup> muscleGroups) {
        List<MuscleGroupResource> resource = new ArrayList<MuscleGroupResource>();

        for (MuscleGroup muscleGroup : muscleGroups){
            resource.add(toResource(muscleGroup));
        }

        return resource;
    }
}
