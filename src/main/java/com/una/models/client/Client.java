package com.una.models.client;

import com.una.models.Person;

import java.time.LocalDate;

public class Client extends Person {
    private String age;
    private LocalDate bornDate;
    public Client(String [] data, LocalDate bornDate) {
        if(data.length == 5){
            this.setName(data[0]);
            this.setEmail(data[1]);
            this.setPhone(data[2]);
            this.setId(data[3]);
            this.setAge(data[4]);
            this.setBornDate(bornDate);
        }

    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public LocalDate getBornDate() {
        return bornDate;
    }
    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }
}
