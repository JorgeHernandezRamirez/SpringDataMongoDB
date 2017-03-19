package com.jorgehernandezramirez.spring.springdata.mongodb.entity;

public class Count {

    private Integer count;

    public Count(){
        //For Spring Data
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Count{" +
                "count=" + count +
                '}';
    }
}
