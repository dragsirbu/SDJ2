public class Main {
    public static final String names[] = AbstractStarSign.LEGAL_NAMES;
    public static final String personNames[] = {"Andrew","Dan","Travis","Jack","John","Mike"};
    public static void main(String[] args) {

        for (int i=0;i<5;i++) {
            Person person = new Person(personNames[(int)(Math.random()*5)],names[(int)(Math.random()*12)]);
            System.out.println(person.toString());
        }

    }
}
