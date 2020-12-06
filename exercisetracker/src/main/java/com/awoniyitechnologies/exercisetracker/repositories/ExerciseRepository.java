package com.awoniyitechnologies.exercisetracker.repositories;

import java.util.List;

import com.awoniyitechnologies.exercisetracker.models.Exercise;
import com.awoniyitechnologies.exercisetracker.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByParent(Exercise exercise);
    List<Exercise> findByUser(User user);
}
