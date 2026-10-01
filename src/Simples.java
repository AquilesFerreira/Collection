public class Simples<E>{
    private Node<E> head, tail;
    private int size;

    public Simples(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(E elemento){
        Node<E> novoNode = new Node<>(elemento);
        if (size == 0){
            head = tail = novoNode;
            size++;
        }else {
            novoNode.setNext(head);
            head = novoNode;
            size++;
        }
    }

    public void addLast(E elemento){
        Node<E> novoNode = new Node<>(elemento);
        if (size == 0){
            head = tail = novoNode;
            size++;
        }else {
            tail.setNext(novoNode);
            tail = novoNode;
            size++;
        }
    }
}
