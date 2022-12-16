package com.example.springboottutorial.model;

import com.example.springboottutorial.payload.JobEnum;
import com.example.springboottutorial.payload.UserPayload;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private JobEnum job;

    private String streetName;

    private String streetNo;

    private String city;

    private String country;

    private String avatar;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JobEnum getJob() {
        return job;
    }

    public void setJob(JobEnum job) {
        this.job = job;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void toEntity(UserPayload payload) {
        this.firstName = payload.getFirstName();
        this.lastName = payload.getLastName();
        this.email = payload.getEmail();
        this.job = payload.getJob();
        this.city = payload.getAddress().getCity();
        this.country = payload.getAddress().getCountry();
        this.streetName = payload.getAddress().getStreetName();
        this.streetNo = payload.getAddress().getStreetNo();
    }
}
