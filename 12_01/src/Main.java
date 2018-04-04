public class Main {

    public static void main(String[] args) {
        Log log = Log.getInstance();
        log.add(new LogLine("removing a cd has been pressed"));
        log.add(new LogLine("title for cd to remove has been entered"));
        log.add(new LogLine("cd has been found in the database"));
        log.add(new LogLine("cd removed"));
    }
}
