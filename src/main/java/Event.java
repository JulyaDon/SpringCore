import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat){
        Random rand = new Random();
        id = rand.nextInt(50) + 1;
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String toString(){
        String data = "ID: " + String.valueOf(id) + ", message: " + msg + ", date: " + dateFormat.format(date);
        return data;
    }
}
