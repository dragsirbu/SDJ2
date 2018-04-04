import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Log {
    private GenQueue<LogLine> logList;
    private File logFile;
    private static Log instance;
    private DateTime date;

    private Log(){
        logList = new GenQueue<>();
        date = new DateTime();
        logFile = new File("C:\\Java\\12_01\\"+date.getSortableDate()+".txt");
    };

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public void add(LogLine log) {
        if (log == null) {
            return;
        }
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(logFile,true));
            logList.enqueue(log);
            out.write(log+"\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public GenQueue<LogLine> getLogList() {
        return logList;
    }
}
