package com.awoniyitechnologies.exercisetracker.media;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResource {
    private Long user_id;
    private String first_name;
    private String last_name;

    // @JsonCreator
    // public UserResource(@JsonProperty("user_id") Long user_id,
    //         @JsonProperty("first_name") String first_name,
    //         @JsonProperty("last_name") String last_name) {
    //     this.user_id = user_id;
    //     this.first_name = first_name;
    //     this.last_name = last_name;
    // }

    public UserResource() {}
    // public UserResource(Long user_id, String first_name, String last_name) {
    //     this.user_id = user_id;
    //     this.first_name = first_name;
    //     this.last_name = last_name;
    // }

    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }

    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }
}
