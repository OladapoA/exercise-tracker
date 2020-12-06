package com.awoniyitechnologies.exercisetracker.repositories;

import com.awoniyitechnologies.exercisetracker.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
