import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App)ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");

        app.logEvent(event, EventType.ERROR);
        app.logEvent(event, EventType.INFO);
        app.logEvent(event, EventType.ERROR);

        ctx.close();
    }
}
