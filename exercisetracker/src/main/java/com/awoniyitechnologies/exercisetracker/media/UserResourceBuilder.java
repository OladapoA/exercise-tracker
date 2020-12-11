package com.awoniyitechnologies.exercisetracker.media;

import com.awoniyitechnologies.exercisetracker.models.User;

import org.springframework.stereotype.Component;

@Component
public class UserResourceBuilder {
    
    public UserResource toResource(User user) {
        UserResource resource = new UserResource();

        resource.setUser_id(user.getUser_id());
        resource.setFirst_name(user.getFirst_name());
        resource.setLast_name(user.getLast_name());

        return resource;
    }
}
