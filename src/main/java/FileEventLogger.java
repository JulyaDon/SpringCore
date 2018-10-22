import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileEventLogger implements IEventLogger{
    private String filename;
    File file;
    boolean canWrite = false;

    public FileEventLogger(String filename){
        this.filename = filename;
    }

    public void init(){
        this.file = new File(filename);
        if(file.canWrite()) canWrite = true;
    }
    public void logEvent(Event event, EventType type){
        if(canWrite) {
            try {
                FileUtils.writeStringToFile(file, event.toString(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("Cannot write to file");
//        BufferedWriter writer = null;
//        try {
//            writer = new BufferedWriter(new FileWriter(filename));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            writer.write(event.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
