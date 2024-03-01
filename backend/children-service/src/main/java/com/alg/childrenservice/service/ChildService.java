package com.alg.childrenservice.service;

import com.alg.childrenservice.model.Child;
import com.alg.childrenservice.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;


    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }


    public Child createChild(Child child) {
        return childRepository.save(child);
    }

    public Child updateChild(Long id, Child updatedChild) {
        Optional<Child> optionalChild = childRepository.findById(id);
        if (optionalChild.isPresent()) {
            Child existingChild = optionalChild.get();
            existingChild.setName(updatedChild.getName());
            existingChild.setAge(updatedChild.getAge());
            existingChild.setImageUrls(updatedChild.getImageUrls());
            existingChild.setParentName(updatedChild.getParentName());
            existingChild.setMessage(updatedChild.getMessage());

            return childRepository.save(existingChild);
        } else {
            throw new IllegalArgumentException("Child not found with id: " + id);
        }

    }

    public void deleteChild(Long id) {
        childRepository.deleteById(id);
    }

    public Child getChildById(Long id) {
        Optional<Child> optionalChild = childRepository.findById(id);
        if (optionalChild.isPresent()) {
            return optionalChild.get();
        } else {
            throw new RuntimeException("Child with ID " + id + " not found");
        }
    }
}
