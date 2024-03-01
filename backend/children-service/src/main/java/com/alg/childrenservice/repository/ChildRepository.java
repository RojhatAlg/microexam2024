package com.alg.childrenservice.repository;

import com.alg.childrenservice.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ChildRepository extends JpaRepository <Child, Long> {
}
