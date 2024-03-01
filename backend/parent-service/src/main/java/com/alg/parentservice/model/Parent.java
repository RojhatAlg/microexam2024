package com.alg.parentservice.model;

import jakarta.persistence.*;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;

    private String childrenName;

    private String messageFromAdmin;


    public Parent() {
    }

    public Parent(Long id, String firstName, String lastName, String address, String childrenName, String messageFromAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.childrenName = childrenName;
        this.messageFromAdmin = messageFromAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChildrenName() {
        return childrenName;
    }

    public void setChildrenName(String childrenName) {
        this.childrenName = childrenName;
    }

    public String getMessageFromAdmin() {
        return messageFromAdmin;
    }

    public void setMessageFromAdmin(String messageFromAdmin) {
        this.messageFromAdmin = messageFromAdmin;
    }
}
