public class Fork {

    private int id;
    private boolean isTaken;

    public Fork(int id) {
        this.id = id;
        this.isTaken = false;
    }

    public synchronized void getFork() {
        while (isTaken) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.isTaken = true;
        System.out.println("--> "+Thread.currentThread().getName()+" took fork "+id);
        notifyAll();
    }

    public synchronized void putBackFork() {
        this.isTaken = false;
        System.out.println("--< "+Thread.currentThread().getName()+" put back fork "+id);
        notifyAll();

    }

    public int getId() {
        return id;
    }
}
