public class LinkedList<E> {
    private Node<E> head, tail;
    private int size;

    LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E element) {
        if (size == 0) {
            head = new Node<>(element);
            tail = new Node<>(element);
            size++;
        } else if (size > 0) {
            Node<E> new_node = new Node<>(element);
            new_node.setNext(head);
            head = new_node;
            size++;
        }
    }

    public void addLast(E element) {
        if (size == 0) {
            head = tail = new Node<>(element);
            size++;
        } else if (size > 0) {
            Node<E> new_node = new Node<>(element);
            tail.setNext(new_node);
            tail = new_node;
            size++;
        }
    }

    public boolean removeFirst() {
        if (size == 0) return false;
        if (size > 0) {
            if (head.getNext() != null) {
                head = head.getNext();
            } else {
                head = tail = null;
            }
            size--;
        }
        return true;
    }

    public boolean removeLast() {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            head = tail = null;
        } else if (size == 2) {
            tail = head;
        } else {

        }
        /*if(size > 0) {
            if(tail != null) {
                tail = tail.getNext();
            }else {
                head = tail = null;
            }
            size --;
        }*/
        return true;
    }

    public void iterator() {
        if (size == 0) {
            System.out.println("LISTA VAZIA.");
        } else if (size > 0) {
            Node<E> node_aux = head;
            while (node_aux != null) {
                System.out.println(node_aux.getElement());
                node_aux = node_aux.getNext();
            }
        }
    }

}