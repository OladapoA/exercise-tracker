package com.awoniyitechnologies.exercisetracker.repositories;

import com.awoniyitechnologies.exercisetracker.models.MuscleGroup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {
}
