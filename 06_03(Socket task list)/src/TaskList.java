import java.util.ArrayList;
public class TaskList
{
    private GenQueue<Task> tasks;
    private static TaskList instance;

    private TaskList()
    {
        tasks = new GenQueue<>();
    }

    public static TaskList getInstance() {
        if (instance == null)
            instance = new TaskList();
        return instance;
    }
    public synchronized void add(Task task)
    {
        tasks.enqueue(task);
    }
    public synchronized Task getAndRemoveNextTask()
    {
        return tasks.dequeue();
    }
    public synchronized int size()
    {
        return tasks.size();
    }
    public String toString()
    {
        return "Tasks=" + tasks;
    }
}