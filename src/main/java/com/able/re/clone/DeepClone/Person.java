package com.able.re.clone.DeepClone;

import java.io.Serializable;

public class Person implements Serializable{

    private String name;

    private Email email;

    public Person(){}

    public Person(String name, Email email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

}
