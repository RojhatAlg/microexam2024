package com.alg.messageservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String messageToParents;

    public Messages() {
    }

    public Messages(Long id, String messageToParents) {
        this.id = id;
        this.messageToParents = messageToParents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageToParents() {
        return messageToParents;
    }

    public void setMessageToParents(String messageToParents) {
        this.messageToParents = messageToParents;
    }

}
