import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger{
    int cacheSize;
    List<Event> cache = new ArrayList<Event>();
    EventType type;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event, EventType type){
        cache.add(event);
        this.type = type;
        if(cacheSize == cache.size()){
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for(Event item : cache){
            super.logEvent(item, type);
        }
    }

    public void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
    }
}
