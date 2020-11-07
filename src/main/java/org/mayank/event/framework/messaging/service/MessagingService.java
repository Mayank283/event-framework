package org.mayank.event.framework.messaging.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mayank.event.framework.Event;

public interface MessagingService
{
    <T extends Event> void pushToTopic(T event, String topic) throws JsonProcessingException;
}
