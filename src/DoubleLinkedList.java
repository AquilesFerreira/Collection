public class DoubleLinkedList<E> {
    private Node<E> head, tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(E elemento) {
        Node<E> novoNode = new Node<>(elemento);
        if (size == 0) {
            head = tail = novoNode;
            novoNode.setPrev(null);
            novoNode.setNext(null);
            size++;
        } else {
            novoNode.setNext(head);
            head.setPrev(novoNode);
            head = novoNode;
            novoNode.setPrev(null);
            size++;
        }
    }

    public void addLast(E elemento) {
        Node<E> novoNode = new Node<>(elemento);
        if (size == 0) {
            head = tail = novoNode;
            novoNode.setPrev(null);
            novoNode.setNext(null);
            size++;
        } else{
            novoNode.setPrev(tail);
            tail.setNext(novoNode);
            tail = novoNode;
            novoNode.setNext(null);
            size++;
        }
    }

    public boolean removeFirst() {
        if (size == 0) {
            return false;
        } else{
            if (head.getNext() != null) {
                head = head.getNext();
                head.setPrev(null);
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
        } else if (size > 0) {
            if (tail.getPrev() != null) {
                tail = tail.getPrev();
                tail.setNext(null);
            } else {
                head = tail = null;
            }
            size--;
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear(){
        head = tail = null;
        size = 0;
    }

    public void add(int indice, E elemento){
        if (indice < 0 || indice > size){
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }

        if (indice == 0){
            addFirst(elemento);
            System.out.println("PRONTO!");
        }else if (indice == size){
            addLast(elemento);
            System.out.println("PRONTO!");
        }else {
            Node<E> novoNode = new Node<>(elemento);
            Node<E> anterior = (Node<E>) get(indice - 1);
            Node<E> proximo = anterior.getNext();

            anterior.setNext(novoNode);
            novoNode.setPrev(anterior);

            novoNode.setNext(proximo);
            proximo.setPrev(novoNode);

            size++;

        }
    }

    public boolean contains(E elemento){
        Node<E> reservarValor = head;

        while (reservarValor != null){
            if ((elemento == null && reservarValor.getElement() == null) || (elemento != null && elemento.equals(reservarValor.getElement()))){
                return true;
            }
            reservarValor = reservarValor.getNext();
        }
        return false;
    }

    public int indexOf(E elemento){
        int contador = 0;
        Node<E> reservar = head;

        while (reservar != null){
            if ((elemento == null && reservar.getElement() == null) || (elemento != null && elemento.equals(reservar.getElement()))){
                return contador;
            }
            contador++;
            reservar = reservar.getNext();
        }
        return -1;
    }

    public E get(int indice){
        if (indice < 0 || indice >= size){
            throw new IndexOutOfBoundsException("O INDICE " + indice + " É INVALIDO.");
        }

        Node<E> reservarValor;

        if (indice < size/2){
            reservarValor = head;
            for (int i = 0; i < indice; i++){
                reservarValor = reservarValor.getNext();
            }
        }else{
            reservarValor = tail;
            for (int i = size - 1; i > indice; i--){
                reservarValor = reservarValor.getPrev();
            }
        }
        return reservarValor.getElement();
    }

    @Override
    public String toString() {
        if (size == 0) {
            System.out.println("[]");
        }

        String resultado = "[";
        Node<E> atual = head;
        while (atual != null) {
            resultado += atual.getElement();
            if (atual.getNext() != null) {
                resultado += ", ";
            }

            atual = atual.getNext();
        }
        resultado += "]";
        return resultado;
    }
}
