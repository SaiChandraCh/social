package com.socials.repository;

import com.socials.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String > {

    public Role findByRole(String role);

}
