package com.alg.messageservice.controller;
import com.alg.messageservice.model.Messages;
import com.alg.messageservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageController {

    private final MessageService messageService ;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/all")
    public void getAllMessages() {
       messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Messages> getMessageById(@PathVariable Long id) {
        Optional<Messages> message = messageService.getMessageById(id);
        return message.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Messages> createMessage(@RequestBody Messages messages) {
        Messages createdMessages = messageService.createMessage(messages);
        return new ResponseEntity<>(createdMessages, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Messages> updateMessage(@PathVariable Long id, @RequestBody Messages messages) {
        Messages updatedMessages = messageService.updateMessage(id, messages);
        return new ResponseEntity<>(updatedMessages, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
