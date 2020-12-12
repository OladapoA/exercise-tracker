package com.awoniyitechnologies.exercisetracker.media;

public class ExerciseResource {

    private Long exercise_id;
    private String name;
    private String description;
    private Long parent_id;
    private String parent_name;
    private Long user_id;

    public ExerciseResource(){}

    public Long getExercise_id() { return exercise_id; }
    public void setExercise_id(Long exercise_id) { this.exercise_id = exercise_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getParent_id() { return parent_id; }
    public void setParent_id(Long parent_id) { this.parent_id = parent_id; }

    public String getParent_name() { return parent_name; }
    public void setParent_name(String parent_name) { this.parent_name = parent_name; }

    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }
}