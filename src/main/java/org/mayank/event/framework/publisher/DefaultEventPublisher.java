package org.mayank.event.framework.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.mayank.event.framework.Event;
import org.mayank.event.framework.autoconfigure.event.EventProperties;
import org.mayank.event.framework.exception.EventPublishingException;
import org.mayank.event.framework.messaging.service.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * {@link DefaultEventPublisher} is used to publish all the events of reviews.
 *
 * @author mayankagarwal
 */
@Slf4j
public class DefaultEventPublisher implements EventPublisher
{
    @Autowired
    private EventProperties eventProperties;

    @Autowired
    private MessagingService messagingService;

    @Override
    public <T extends Event> void publishEvent(T event) throws EventPublishingException
    {
        EventProperties.Topic topic = eventProperties.getEvent().get(event.getEventType());

        try
        {
            messagingService.pushToTopic(event, topic.getTopicName());
        }
        catch (JsonProcessingException ex)
        {
            log.info("Exception while publishing event due to {}", ex.getMessage());
            throw new EventPublishingException(ex);
        }
    }
}
