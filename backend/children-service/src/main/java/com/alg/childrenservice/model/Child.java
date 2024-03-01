package com.alg.childrenservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String age;

    private String parentName;

    private String message;


    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> imageUrls;

    public Child() {
    }

    public Child(Long id, String name, String age, List<String> imageUrls, String parentName, String message) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.imageUrls = imageUrls;
        this.parentName = parentName;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
