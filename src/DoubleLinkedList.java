public class DoubleLinkedList<E> {
    private Node<E> head, tail;
    private int size;

    public DoubleLinkedList(){
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
        } else if (size > 0){
            novoNode.setPrev(tail);
            tail.setNext(novoNode);
            tail = novoNode;
            novoNode.setNext(null);
            size++;
        }
    }

    public boolean removeFirst(){
        if (size == 0){
            return false;
        }else if (size > 0){
            if (head.getNext() != null){
                head = head.getNext();
                head.setPrev(null);
            }else {
                head = tail = null;
            }
            size --;
        }
        return true;
    }

    public boolean removeLast() {
        if (size == 0){
            return false;
        }else if (size > 0) {
            if (tail.getPrev() != null){
                tail = tail.getPrev();
                tail.setNext(null);
            }else {
                head = tail = null;
            }
            size--;
        }
        return true;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        if (size == 0){
            System.out.println("[]");
        }else {
            Node<E> atual = head;
            while (atual != null /*&& atual*/){
                System.out.print("[" + atual.getElement() + "]" + ",");
                if (atual.getNext() != null){

                }
            }
        }
    }
}
