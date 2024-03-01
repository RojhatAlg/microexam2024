package com.alg.parentservice.service;

import com.alg.parentservice.model.Parent;
import com.alg.parentservice.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }


    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    public Optional<Parent> getParentById(Long id) {
        return parentRepository.findById(id);
    }

    public Parent updateParent(Long id, Parent updatedParent) {
        Optional<Parent> optionalParent = parentRepository.findById(id);
        if (optionalParent.isPresent()) {
            Parent existingParent = optionalParent.get();
            existingParent.setFirstName(updatedParent.getFirstName());
            existingParent.setLastName(updatedParent.getLastName());
            existingParent.setAddress(updatedParent.getAddress());
            existingParent.setChildrenName(updatedParent.getChildrenName());
            existingParent.setMessageFromAdmin(updatedParent.getMessageFromAdmin());
            return parentRepository.save(existingParent);
        } else {
            throw new IllegalArgumentException("Parent not found with id: " + id);
        }
    }

    public void deleteParent(Long id) {
        parentRepository.deleteById(id);
    }
}
