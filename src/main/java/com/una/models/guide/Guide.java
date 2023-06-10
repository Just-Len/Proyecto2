package com.una.models.guide;

import com.una.models.Person;

import java.time.LocalDate;

public class Guide extends Person {
    private String age;
    private LocalDate bornDate;
    private String guideId;
    public Guide(String [] data, LocalDate bornDate) throws Exception {
        if(data.length == 6){
            this.setName(data[0]);
            this.setEmail(data[1]);
            this.setPhone(data[2]);
            this.setId(data[3]);
            this.setAge(data[4]);
            this.setGuideId(data[5]);
            this.setBornDate(bornDate);
        }else{
            throw new Exception("Faltan datos en el arreglo");
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

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }
}
