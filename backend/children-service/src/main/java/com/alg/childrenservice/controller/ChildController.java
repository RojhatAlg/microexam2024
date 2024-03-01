package com.alg.childrenservice.controller;

import com.alg.childrenservice.model.Child;
import com.alg.childrenservice.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/children")
public class ChildController {

    private final ChildService childService;


    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping
    public List<Child> getChildren(){
        return childService.getAllChildren();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Child> getChildById(@PathVariable Long id) {
        Child child = childService.getChildById(id);
        return new ResponseEntity<>(child, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Child> createChild(@RequestBody Child child) {
        Child createdChild = childService.createChild(child);
        return new ResponseEntity<>(createdChild, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Child> updateChild(@PathVariable Long id, @RequestBody Child child) {
        Child updatedChild = childService.updateChild(id, child);
        return new ResponseEntity<>(updatedChild, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChild(@PathVariable Long id) {
        childService.deleteChild(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
