package com.awoniyitechnologies.exercisetracker.media;

import java.util.ArrayList;
import java.util.List;

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

    public List<UserResource> toResource(List<User> users) {
        List<UserResource> resource = new ArrayList<UserResource>();

        for (User user : users){
            resource.add(this.toResource(user));
        }

        return resource;
    }
}
