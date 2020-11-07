package org.mayank.event.framework.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mayank.event.framework.autoconfigure.event.EventProperties;
import org.mayank.event.framework.messaging.service.MessagingService;
import org.mayank.event.framework.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * {@link EventPublisher} is used to publish all the events of reviews.
 *
 * @author mayankagarwal
 */

@Service
public class EventPublisher
{
    @Autowired
    private EventProperties eventProperties;

    @Autowired
    private MessagingService messagingService;

    public <T extends Event> void publishEvent(T event) throws JsonProcessingException
    {
        EventProperties.Topic topic = eventProperties.getEvent().get(event.getEventType());

        messagingService.pushToTopic(event, topic.getTopicName());
    }
}
