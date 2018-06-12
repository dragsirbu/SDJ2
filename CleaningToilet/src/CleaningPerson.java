public class CleaningPerson implements Runnable {

    private PublicToilet toilet;

    public CleaningPerson(PublicToilet toilet) {
        this.toilet = toilet;
    }

    @Override
    public void run() {
        toilet.cleanToilet();
        timeToWait(7000);
        toilet.endCleaningToilet();
    }


    private void timeToWait(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
