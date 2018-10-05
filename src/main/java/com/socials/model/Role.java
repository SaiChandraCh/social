package com.socials.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Role")
public class Role {

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    private String role;

}
