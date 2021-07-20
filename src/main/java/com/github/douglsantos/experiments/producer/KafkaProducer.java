package com.github.douglsantos.experiments.producer;

import avro.example.entity.UserAvroEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

@Slf4j
@RestController
public class KafkaProducer {

    private final KafkaTemplate<String, UserAvroEntity> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, UserAvroEntity> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/users")
    public void send() {
        kafkaTemplate.send("new_user", UserAvroEntity
                .newBuilder()
                .setName("Douglas Santos")
                .setBirth(LocalDate.of(1995, Month.JANUARY, 15))
                .build());
    }
}
