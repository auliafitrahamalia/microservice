package com.aulia.consumer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConsumerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message){
        System.out.print("Received: " + message);
    }

    public void sendMessage(String message){
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("sent: "+ message);
    }
}
