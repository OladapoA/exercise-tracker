package com.awoniyitechnologies.exercisetracker.media;

import java.util.ArrayList;
import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.Exercise;
import com.awoniyitechnologies.exercisetracker.models.MuscleGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExerciseResourceBuilder {

    private MuscleGroupResourceBuilder muscleGroupResourceBuilder;

    @Autowired
    public ExerciseResourceBuilder(MuscleGroupResourceBuilder muscleGroupResourceBuilder){
        this.muscleGroupResourceBuilder = muscleGroupResourceBuilder;
    }
    
    public ExerciseResource toResource(Exercise exercise) {

        ExerciseResource resource = new ExerciseResource();

        resource.setExercise_id(exercise.getExercise_id());
        resource.setName(exercise.getName());
        resource.setDescription(exercise.getDescription());
        resource.setUser_id(exercise.getUser().getUser_id());

        if (exercise.getParent() != null) {
            resource.setParent_id(exercise.getParent().getExercise_id());
            resource.setParent_name(exercise.getParent().getName());
        }

        List<MuscleGroupResource> muscleGroupResources = new ArrayList<MuscleGroupResource>();
        for (MuscleGroup muscleGroup : exercise.getMuscle_groups()){
            muscleGroupResources.add(muscleGroupResourceBuilder.toResource(muscleGroup));
        }
        resource.setMuscle_groups(muscleGroupResources);

        return resource;
    }

    public List<ExerciseResource> toResource(List<Exercise> exercises) {
        List<ExerciseResource> resource = new ArrayList<ExerciseResource>();

        for (Exercise exercise : exercises){
            resource.add(this.toResource(exercise));
        }

        return resource;
    }
}
