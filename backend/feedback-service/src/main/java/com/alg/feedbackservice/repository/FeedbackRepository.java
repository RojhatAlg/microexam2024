package com.alg.feedbackservice.repository;

import com.alg.feedbackservice.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository <Feedback, Long> {
}
