package org.mayank.event.framework;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * {@link Event} is base event class containing basic event properties.
 *
 * @author mayankagarwal
 */
@Getter
@Setter
@ToString
public abstract class Event
{
    @NonNull
    private String eventId;

    @NonNull
    private String eventType;
}
