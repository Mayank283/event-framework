package org.mayank.event.framework.exception;

/**
 * @author mayankagarwal
 */

public class EventPublishingException extends Exception
{
    public EventPublishingException()
    {
        super();
    }

    public EventPublishingException(String message)
    {
        super(message);
    }

    public EventPublishingException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public EventPublishingException(Throwable cause)
    {
        super(cause);
    }
}
