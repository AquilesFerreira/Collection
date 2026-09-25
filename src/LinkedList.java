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
            head = tail = new Node<>(element);
            size++;
        } else {
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
        if (size == 0) {
            return false;
        }else if (size > 0) {
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
            Node<E> atual = head;
            while (atual.getNext() != tail){
                atual = atual.getNext();
            }
            tail = atual;
            tail.setNext(null);
        }
        size--;
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

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }

        Node<E> atual = head;
        for (int i = 0; i < index; i++) {
            atual = atual.getNext();
        }

        return atual.getElement();
    }

    public boolean contains(E element) {
        Node<E> atual = head;

        while (atual != null) {
            // Cuidado com null
            if ((element == null && atual.getElement() == null) ||
                    (element != null && element.equals(atual.getElement()))) {
                return true;
            }
            atual = atual.getNext();
        }

        return false;
    }

    public int indexOf(E element) {
        Node<E> atual = head;
        int index = 0;

        while (atual != null) {
            if ((element == null && atual.getElement() == null) ||
                    (element != null && element.equals(atual.getElement()))) {
                return index;
            }
            atual = atual.getNext();
            index++;
        }

        return -1;  // Não encontrado
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<E> novo = new Node<>(element);
            Node<E> anterior = head;

            for (int i = 0; i < index - 1; i++) {
                anterior = anterior.getNext();
            }

            novo.setNext(anterior.getNext());
            anterior.setNext(novo);
            size++;
        }
    }

    public boolean remove(E element) {
        if (size == 0) return false;

        // Verifica se é o primeiro
        if ((element == null && head.getElement() == null) ||
                (element != null && element.equals(head.getElement()))) {
            return removeFirst();
        }

        // Verifica se é o último
        if ((element == null && tail.getElement() == null) ||
                (element != null && element.equals(tail.getElement()))) {
            return removeLast();
        }

        // Procura no meio
        Node<E> atual = head;
        while (atual.getNext() != null) {
            if ((element == null && atual.getNext().getElement() == null) ||
                    (element != null && element.equals(atual.getNext().getElement()))) {
                atual.setNext(atual.getNext().getNext());
                size--;
                return true;
            }
            atual = atual.getNext();
        }

        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }

        E elemento;

        if (index == 0) {
            elemento = head.getElement();
            removeFirst();
        } else if (index == size - 1) {
            elemento = tail.getElement();
            removeLast();
        } else {
            Node<E> anterior = head;
            for (int i = 0; i < index - 1; i++) {
                anterior = anterior.getNext();
            }
            elemento = anterior.getNext().getElement();
            anterior.setNext(anterior.getNext().getNext());
            size--;
        }

        return elemento;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
        // O(1) porque não percorre - só zera referências
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<E> atual = head;

        while (atual != null) {
            sb.append(atual.getElement());
            if (atual != tail) {
                sb.append(", ");
            }
            atual = atual.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

}