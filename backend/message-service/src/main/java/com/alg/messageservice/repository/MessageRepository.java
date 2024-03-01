package com.alg.messageservice.repository;

import com.alg.messageservice.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository <Messages, Long> {
}
