package com.alg.parentservice.controller;

import com.alg.parentservice.model.Parent;
import com.alg.parentservice.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
        Parent createdParent = parentService.createParent(parent);
        return new ResponseEntity<>(createdParent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Parent>> getAllParents() {
        List<Parent> parents = parentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable Long id) {
        return parentService.getParentById(id)
                .map(parent -> new ResponseEntity<>(parent, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> updateParent(@PathVariable Long id, @RequestBody Parent updatedParent) {
        try {
            Parent parent = parentService.updateParent(id, updatedParent);
            return new ResponseEntity<>(parent, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
