package com.awoniyitechnologies.exercisetracker.media;

public class MuscleGroupResource {
    private Long muscle_group_id;
    private String major_name;
    private String minor_name;
    private int no_of_exercises;

    MuscleGroupResource(){}

    public Long getMuscle_group_id() { return muscle_group_id; }
    public void setMuscle_group_id(Long muscle_group_id) { this.muscle_group_id = muscle_group_id; }

    public String getMajor_name() { return major_name; }
    public void setMajor_name(String major_name) { this.major_name = major_name; }

    public String getMinor_name() { return minor_name; }
    public void setMinor_name(String minor_name) { this.minor_name = minor_name; }

    public int getNo_of_exercises() { return no_of_exercises; }
    public void setNo_of_exercises(int no_of_exercises) { this.no_of_exercises = no_of_exercises; }
}
