public class Person {

    private String name;
    private AbstractStarSign starSign;

    public Person(String name,String starSignName) {
        this.name = name;
        this.starSign = StarSignFactory.getStarSign(starSignName);
    }

    public String getName() {
        return this.name;
    }

    public AbstractStarSign getStarSign() {
        return starSign;
    }

    public String toString() {
        return name + ", " + starSign;
    }
}
