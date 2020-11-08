package org.mayank.event.framework.messaging.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mayank.event.framework.Event;

/**
 * {@link MessagingService} is the base interface for different messaging bus implementation.
 *
 * @author mayankagarwal
 */
public interface MessagingService
{
    <T extends Event> void pushToTopic(T event, String topic) throws JsonProcessingException;
}
