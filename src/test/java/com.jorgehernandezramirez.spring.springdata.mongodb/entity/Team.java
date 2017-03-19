package com.jorgehernandezramirez.spring.springdata.mongodb.entity;

public class Team {

    private String name;

    private String sport;

    public Team(){
        //For Spring Data
    }

    public Team(String name, String sport) {
        this.name = name;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", sport='" + sport + '\'' +
                '}';
    }
}
