package com.github.douglsantos.experiments.consumer;

import avro.example.entity.UserAvroEntity;
import com.github.douglsantos.experiments.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "new_user")
    public void receive(@Payload GenericRecord payload) {
        var userDomain = UserMapper.INSTANCE.toDomain((UserAvroEntity) payload);
        log.info("Name: {} Birth: {}", userDomain.getName(), userDomain.getBirth());
    }

}
