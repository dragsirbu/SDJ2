public class Main {

    public static void main(String[] args) {
        PublicToilet toilet = new ToiletBuilding(5,2,1);
        Person person1 = new Person("Marti",toilet);
        Person person2 = new Person("Roko",toilet);
        Person person3 = new Person("John",toilet);
        Person person4 = new Person("Donald",toilet);
        Person person5 = new Person("Vlad",toilet);
        Person person6 = new Person("Kim",toilet);
        Person person7 = new Person("Andrew",toilet);
        Person person8 = new Person("Nina",toilet);
        Person person9 = new Person("Jessica",toilet);
        Person person10 = new Person("Greg",toilet);
        Person person11 = new Person("Ross",toilet);
        Person person12 = new Person("Ethan",toilet);

        Thread t1 = new Thread(person1);
        Thread t2 = new Thread(person2);
        Thread t3 = new Thread(person3);
        Thread t4 = new Thread(person4);
        Thread t5 = new Thread(person5);
        Thread t6 = new Thread(person6);
        Thread t7 = new Thread(person7);
        Thread t8 = new Thread(person8);
        Thread t9 = new Thread(person9);
        Thread t10 = new Thread(person10);
        Thread t11 = new Thread(person11);
        Thread t12 = new Thread(person12);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
    }
}
