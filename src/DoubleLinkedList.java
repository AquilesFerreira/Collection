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

    public E removeIndex(int posicao){
        if (posicao < 0 || posicao >= size){
            throw new IndexOutOfBoundsException("Indice invalido.");
        }

        E elementoRemovido;

        if (posicao == 0){
            elementoRemovido = head.getElement();
            removeFirst();
        }else if (posicao == size - 1){
            elementoRemovido = tail.getElement();
            removeLast();
        }else {
            Node<E> atual;
            if (posicao < size/2){
                atual = head;
                for (int i = 0; i < posicao; i++){
                    atual = atual.getNext();
                }
            }else{
                atual = tail;
                for (int i = size - 1; i > posicao; i--){
                    atual = atual.getPrev();
                }
            }
            elementoRemovido = atual.getElement();
            atual.getPrev().setNext(atual.getNext());
            atual.getNext().setPrev(atual.getPrev());
            atual.setPrev(null);
            atual.setNext(null);
            size--;
        }

        return elementoRemovido;
    }

    public boolean removeElement(E elemento){
        if (size == 0){return false;}

        if ((elemento == null && head.getElement() == null) || (elemento != null && elemento.equals(head.getElement()))){
            return removeFirst();
        }

        Node<E> atual = head;

        while (atual.getNext() != null){
            if ((elemento == null && atual.getElement() == null) || (elemento != null && elemento.equals(atual.getElement()))){
                atual.getPrev().setNext(atual.getNext());
                atual.getNext().setPrev(atual.getPrev());
                atual.setPrev(null);
                atual.setNext(null);
                size--;
                return true;
            }
            atual = atual.getNext();
        }

        if ((elemento == null && tail.getElement() == null) || (elemento != null && elemento.equals(tail.getElement()))){
            return removeLast();
        }

        return false;
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

    public void add(int posicao, E elemento){
        if (posicao < 0 || posicao > size){
            throw new IndexOutOfBoundsException("Indice invalido");
        }

        Node<E> novo = new Node<>(elemento);
        Node<E> atual = head;

        if (posicao == 0){
            addFirst(elemento);
        }else if (posicao == size){
            addLast(elemento);
        }else {
            for (int i = 0; i < posicao; i++){
                atual = atual.getNext();
            }
            novo.setPrev(atual.getPrev());
            atual.getPrev().setNext(novo);
            novo.setNext(atual);
            atual.setPrev(novo);
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

    public E set(int indice, E elemento){
        if (indice < 0 || indice >= size){
            throw new IndexOutOfBoundsException("Indice invalido.");
        }

        Node<E> atual = head;
        for (int i = 0; i < indice; i++){
            atual = atual.getNext();
        }

        E velha = atual.getElement();
        atual.setElement(elemento);

        return velha;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
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
