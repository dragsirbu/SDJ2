public interface PublicToilet
{
    // wait if there are no available cabins or if it is not your turn
    void stepIntoCabin(Person person);
    void leaveCabin(Person person);
    // wait if there are no available faucets or if it is not your turn
    void washHands(Person person);
    void stopWashingHands(Person person);
    // wait if there are no available hand dryers or if it is not your turn
    void cleanToilet();
    void endCleaningToilet();
}
