import java.util.ArrayList;
public class TaskList
{
    private GenQueue<Task> tasks;

    public TaskList()
    {
        tasks = new GenQueue<>();
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