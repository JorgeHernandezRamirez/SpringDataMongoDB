package com.jorgehernandezramirez.spring.springdata.mongodb.entity;

public class UserGenderCount {

    private String gender;

    private Integer count;

    public UserGenderCount(){
        //For Spring Data
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserGenderCount{" +
                "gender='" + gender + '\'' +
                ", count=" + count +
                '}';
    }
}
