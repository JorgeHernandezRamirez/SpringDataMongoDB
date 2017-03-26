package com.jorgehernandezramirez.spring.springdata.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user")
public class UserEntity {

    @Id
    private String id;

    private String name;

    private String surname;

    private String gender;

    private List<String> roles;

    private List<Team> teams;

    public UserEntity(){
        //For Spring Data
    }

    public UserEntity(String id, String name, String surname, String gender, List<String> roles, List<Team> teams) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.roles = roles;
        this.teams = teams;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", roles=" + roles +
                ", teams=" + teams +
                '}';
    }
}
