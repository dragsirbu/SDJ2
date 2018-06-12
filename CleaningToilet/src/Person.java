public class Person implements Runnable {

    private String name;
    private PublicToilet toilet;

    public Person(String name, PublicToilet toilet) {
        this.name = name;
        this.toilet = toilet;
    }

    @Override
    public void run() {
        toilet.stepIntoCabin(this);
        timeToWait(5000);
        toilet.leaveCabin(this);
        toilet.washHands(this);
        timeToWait(3000);
        toilet.stopWashingHands(this);
    }

    public String getName() {
        return name;
    }

    private void timeToWait(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
