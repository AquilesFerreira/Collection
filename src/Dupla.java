public class Dupla<E> {
    private Node<E> head, tail;
    private int size;

    public Dupla(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(E elemento){
        Node<E> novoNode = new Node<>(elemento);
        if (size == 0){
            head = tail = novoNode;
            novoNode.setPrev(null);
            novoNode.setNext(null);
            size++;
        }else {
            novoNode.setNext(head);
            head.setPrev(novoNode);
            head = novoNode;
            novoNode.setPrev(null);
            size++;
        }
    }

    public void addLast(E elemento){
        Node<E> novoNode = new Node<>(elemento);
        if (size == 0){
            head = tail = novoNode;
            novoNode.setPrev(null);
            novoNode.setNext(null);
            size++;
        }else {
            tail.setNext(novoNode);
            novoNode.setPrev(tail);
            tail = novoNode;
            size++;
        }
    }


}
