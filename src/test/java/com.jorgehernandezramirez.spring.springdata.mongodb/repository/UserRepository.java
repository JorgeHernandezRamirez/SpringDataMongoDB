package com.jorgehernandezramirez.spring.springdata.mongodb.repository;

import com.jorgehernandezramirez.spring.springdata.mongodb.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Repository de la entidad User
 */
public interface UserRepository extends MongoRepository<UserEntity, String> {

    List<UserEntity> findByName(String name);

    @Query("{'teams.name': ?0}")
    List<UserEntity> findByTeamname(String teamName);
}
