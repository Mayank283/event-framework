package org.mayank.event.framework.publisher;

import org.mayank.event.framework.Event;
import org.mayank.event.framework.exception.EventPublishingException;

/**
 * {@link EventPublisher} is the base interface for publishing events.
 *
 * @author mayankagarwal
 */
public interface EventPublisher
{
    <T extends Event> void publishEvent(T event) throws EventPublishingException;
}
