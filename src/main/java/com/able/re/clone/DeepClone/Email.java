package com.able.re.clone.DeepClone;

import java.io.Serializable;

public class Email implements Serializable{

    private int id;
    private String content;

    public Email(){}

    public Email(int id, String content){
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
