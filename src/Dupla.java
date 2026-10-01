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

    // remove(int index) - boolean
    public boolean remove(int indice){
        if (indice < 0 || indice >= size){
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }

        if (size == 1){
            head = tail = null;
        } else if (indice == 0){
            removeFirst();
            return true;
        } else if (indice == size - 1){
            removeLast();
            return true;
        } else {
            Node<E> nó = get(indice);
            nó.getPrev().setNext(nó.getNext());
            nó.getNext().setPrev(nó.getPrev());
        }

        size--;
        return true;
    }

    // remove(E element) - boolean
    public boolean remove(E elemento){
        if (size == 0){
            return false;
        }

        // Se é o primeiro
        if ((elemento == null && head.getElement() == null) ||
                (elemento != null && elemento.equals(head.getElement()))){
            return removeFirst();
        }

        // Se é o último
        if ((elemento == null && tail.getElement() == null) ||
                (elemento != null && elemento.equals(tail.getElement()))){
            return removeLast();
        }

        // Procura no meio
        Node<E> atual = head;
        while (atual != null){
            if ((elemento == null && atual.getElement() == null) ||
                    (elemento != null && elemento.equals(atual.getElement()))){
                atual.getPrev().setNext(atual.getNext());
                atual.getNext().setPrev(atual.getPrev());
                size--;
                return true;
            }
            atual = atual.getNext();
        }

        return false;
    }
}
