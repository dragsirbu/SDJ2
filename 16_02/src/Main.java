public class Main {

    public static void main(String[] args) {
        ThreadSafeList<String> list = new ThreadSafeList<String>(new ArrayList<>());
        list.add("Dragos");
        list.add("Me");
        list.add("FGHJ");
        System.out.println(list.toString());
        list.set(0,"QWER");
        System.out.println(list.remove(2));
        list.remove("Me");
        System.out.println(list.toString());

    }
}
