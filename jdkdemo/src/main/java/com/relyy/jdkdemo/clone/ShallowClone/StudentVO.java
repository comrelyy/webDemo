package com.relyy.jdkdemo.clone.ShallowClone;

public class StudentVO implements Cloneable{

    private int id;

    private String stuName;

    private Address address;


    public StudentVO() {
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", address='" + address.getAddre() + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        //address.setAddre("iiii");
    }
}
