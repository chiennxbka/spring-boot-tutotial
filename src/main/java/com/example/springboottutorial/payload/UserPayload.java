package com.example.springboottutorial.payload;

import org.springframework.web.multipart.MultipartFile;

public class UserPayload {

    private String firstName;

    private String lastName;

    private String email;

    private JobEnum job;

    private Address address;

    private MultipartFile avatar;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
