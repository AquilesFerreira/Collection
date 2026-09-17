public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();

        lista.addFirst(10);
        lista.addFirst(20);
        lista.addFirst(30);
        lista.addLast(40);

        System.out.println(lista);           // [30, 20, 10, 40]
        System.out.println(lista.size());    // 4
        System.out.println(lista.get(1));    // 20
        System.out.println(lista.contains(40)); // true
        System.out.println(lista.indexOf(40));  // 3

        lista.add(1, 99);
        System.out.println(lista);           // [30, 99, 20, 10, 40]

        lista.removeLast();
        System.out.println(lista);           // [30, 99, 20, 10]

        lista.remove(Integer.valueOf(99));
        System.out.println(lista);           // [30, 20, 10]

        lista.remove(0);
        System.out.println(lista);           // [20, 10]

        lista.clear();
        System.out.println(lista.isEmpty()); // true
        System.out.println(lista);           // []

    }
}