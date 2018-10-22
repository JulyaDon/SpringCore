import com.sun.xml.internal.fastinfoset.stax.EventLocation;

import java.util.Map;

public class App {
    private Client client;
    private IEventLogger eventLogger;
    private IEventLogger defaultLogger = new ConsoleEventLogger();
    Map<EventType, IEventLogger> loggers;

    public App(Client client, IEventLogger eventLogger, Map<EventType, IEventLogger> loggers){
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(Event event, EventType type)
    {
        IEventLogger logger = loggers.get(type);
        if(logger==null){
            logger = defaultLogger;
        }
        logger.logEvent(event, type);
    }
}
