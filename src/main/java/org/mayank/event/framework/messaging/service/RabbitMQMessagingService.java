package org.mayank.event.framework.messaging.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.mayank.event.framework.Event;

/**
 * {@link RabbitMQMessagingService} implements {@link MessagingService} to publish event on RabbitMQ event bus.
 *
 * @author mayankagarwal
 */
@Slf4j
public class RabbitMQMessagingService implements MessagingService
{
    @Override
    public <T extends Event> void pushToTopic(T event, String topic) throws JsonProcessingException
    {

    }
}
