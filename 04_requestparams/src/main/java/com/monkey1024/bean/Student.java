package com.monkey1024.bean;

public class Student {
    private String username;
    private int age;
    private School school;
    private School address;
        //将school对象作为Student中的一个属性，这是一个对象属性
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public School getAddress() {
        return address;
    }

    public void setAddress(School address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
