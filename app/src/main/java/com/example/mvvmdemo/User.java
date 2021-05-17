package com.example.mvvmdemo;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String id;

    public User() {

    }

    public User(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
