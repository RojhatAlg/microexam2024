package com.alg.feedbackservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String messageToAdmin;

    public Feedback() {
    }


    public Feedback(String messageToAdmin, String email) {
        this.messageToAdmin = messageToAdmin;
    }

    public Feedback(String message) {
        this.messageToAdmin= message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageToAdmin() {
        return messageToAdmin;
    }

    public void setMessageToAdmin(String messageToAdmin) {
        this.messageToAdmin = messageToAdmin;
    }

}
