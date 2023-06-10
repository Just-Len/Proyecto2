package com.una.models.user;

import com.una.models.Person;

import java.io.Serial;
import java.io.Serializable;

public class User extends Person implements Serializable {

    private String username;
    private String password;
    @Serial
    private static final long serialVersionUID = -3156734247954624095L;
    public User(String [] data)throws Exception {
        if(data.length == 6){
        this.setUsername(data[0]);
        this.setPassword(data[1]);
        this.setName(data[2]);
        this.setEmail(data[3]);
        this.setPhone(data[4]);
        this.setId(data[5]);
        } else {
            throw new Exception("Los datos proporcionados no son suficientes");
        }
    }
    public User(String adminUsername, String adminPassword) {
        this.username = adminUsername;
        this.password = adminPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

}