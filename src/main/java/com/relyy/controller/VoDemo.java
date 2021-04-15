package com.relyy.controller;

public class VoDemo {

    private int id;

    private String name;

    private Integer age;

    private String phoneNum;

    private String exam;

    public VoDemo(){}

    public VoDemo(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "VoDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNum='" + phoneNum + '\'' +
                ", exam='" + exam + '\'' +
                '}';
    }
}
