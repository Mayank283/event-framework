package org.mayank.event.framework.messaging.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.mayank.event.framework.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author mayankagarwal
 */

@Slf4j
public class KafkaMessagingService implements MessagingService
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public <T extends Event> void pushToTopic(T event, String topic) throws JsonProcessingException
    {
        String eventJson = getEventJsonString(event);
        ListenableFuture<SendResult<String, String>> deliveredMessage = kafkaTemplate.send(topic, event.getEventId(),
                                                                                            eventJson);
        deliveredMessage.addCallback(new ListenableFutureCallback<SendResult<String, String>>()
        {
            @Override
            public void onSuccess(SendResult<String, String> sendResult)
            {
                long offset = sendResult.getRecordMetadata().offset();
                int partition = sendResult.getRecordMetadata().partition();
                log.info("{} published successfully at {}-partition-{} with offset {}", event, topic, partition,
                         offset);
            }

            @Override
            public void onFailure(Throwable throwable)
            {
                log.info("Failed to publish event {} to topic {} with exception {}", event, topic,
                         throwable.getMessage());
            }
        });
    }

    private <T extends Event> String getEventJsonString(T event) throws JsonProcessingException
    {
        try
        {
            return getObjectMapper().writeValueAsString(event);
        }
        catch (JsonProcessingException ex)
        {
            log.info("[Kafka Messaging] Error while parsing event {} with exception", event, ex);
            throw ex;
        }
    }

    private static ObjectMapper getObjectMapper()
    {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return OBJECT_MAPPER;
    }
}
