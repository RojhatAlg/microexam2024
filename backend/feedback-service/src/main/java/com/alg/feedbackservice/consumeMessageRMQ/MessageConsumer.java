package com.alg.feedbackservice.consumeMessageRMQ;

import com.alg.feedbackservice.model.Feedback;
import com.alg.feedbackservice.repository.FeedbackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    private final FeedbackRepository feedbackRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    public MessageConsumer(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @RabbitListener(queues = "${spring.rabbitmq.listener.simple.default-receive-queue}")
    public void consume(ChildreClass message) {
        LOGGER.info("The message has arrived: {}", message);

        // Save to database
        Feedback feedback = new Feedback();
        feedback.setMessageToAdmin(message.getMessage());
        feedbackRepository.save(feedback); 
        LOGGER.info("Message saved to the database.");
    }

    public static class ChildreClass {
        private Long id;
        private String message;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
