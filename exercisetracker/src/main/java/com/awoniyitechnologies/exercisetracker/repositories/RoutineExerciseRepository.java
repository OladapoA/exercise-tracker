package com.awoniyitechnologies.exercisetracker.repositories;

import com.awoniyitechnologies.exercisetracker.models.RoutineExercise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineExerciseRepository extends JpaRepository<RoutineExercise, Long> {
}
