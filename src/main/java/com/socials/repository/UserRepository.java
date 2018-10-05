package com.socials.repository;


import com.socials.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findById(ObjectId id);
    User findUsersByUserNameAndPassword(String userName, String password);
}
