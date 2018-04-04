public class LogLine {
    private String text;
    private DateTime date;

    public LogLine(String text) {
        this.text = text;
        this.date = new DateTime();
    }

    public String getLogText() {
        return text;
    }

    public DateTime getDate() {
        return date;
    }

    public String getTimeStamp() {
        return date.getTimestamp();
    }

    public String toString() {
        return this.getTimeStamp()+" "+this.getLogText();
    }
}
