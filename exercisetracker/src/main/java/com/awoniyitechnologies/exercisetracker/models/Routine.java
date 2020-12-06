package com.awoniyitechnologies.exercisetracker.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "routines")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routine_id;
    
    private Boolean is_public;
    private String name;
    private String description;
    private Timestamp created_at;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Long getRoutine_id() { return routine_id; }
    public void setRoutine_id(Long routine_id) { this.routine_id = routine_id; }

    public Boolean getIs_public() { return is_public; }
    public void setIs_public(Boolean is_public) { this.is_public = is_public; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Timestamp getCreated_at() { return created_at; }
    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
