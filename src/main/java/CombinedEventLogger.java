import java.util.List;

public class CombinedEventLogger implements IEventLogger {
    List<IEventLogger> loggers;
    public CombinedEventLogger(List<IEventLogger> loggers){
        this.loggers = loggers;
    }
    public void logEvent(Event event, EventType type) {
        for(IEventLogger logger : loggers){
            logger.logEvent(event, type);
        }
    }
}
