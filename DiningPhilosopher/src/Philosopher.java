public class Philosopher implements Runnable {

    private int id;
    private Fork rightFork;
    private Fork leftFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        if (id > rightFork.getId() || id > leftFork.getId()) {
            this.leftFork = rightFork;
            this.rightFork = leftFork;
        }else {
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }
    }

    @Override
    public void run() {
        while (true)
        {
            System.out.println("THINK ("+Thread.currentThread().getName()+")");
            timeToWait(5000);
            leftFork.getFork();
            rightFork.getFork();
            timeToWait(2500);
            System.out.println(Thread.currentThread().getName()+" finished eating for now.");
            rightFork.putBackFork();
            leftFork.putBackFork();
        }
    }

    private void timeToWait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
