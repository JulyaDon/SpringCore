public class ConsoleEventLogger implements IEventLogger{
    public void logEvent(Event event, EventType type){
        System.out.println("info: " + event.toString());
    }
}
