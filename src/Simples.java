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
            tail = novoNode;
        }else {
            novoNode.setNext(head);
        }
        head = novoNode;
        size++;
    }

    public void addLast(E elemento){
        Node<E> novoNode = new Node<>(elemento);
        if (size == 0){
            head = novoNode;
        }else {
            tail.setNext(novoNode);
        }
        tail = novoNode;
        size++;
    }

    public void add(int indice, E elemento){
        Node<E> novoNode = new Node<>(elemento);
        if (indice < 0 || indice > size){
            throw new IndexOutOfBoundsException("Indice invalido.");
        }

        if (indice == 0){
            addFirst(elemento);
        }else if (indice == size){
            addLast(elemento);
        } else {
            Node<E> referencia = head;
            for (int i = 0; i < indice - 1; i++){
                referencia = referencia.getNext();
            }
            novoNode.setNext(referencia.getNext());
            referencia.setNext(novoNode);
            size++;
        }

    }

    public boolean removeFirst(){
        if (size == 0){return false;}
        if (head.getNext() == null) {
            head = tail = null;
        }else {
            head = head.getNext();
        }
        size --;
        return true;
    }

    public boolean removeLast(){
        if (size == 0){return false;}
        if (head.getNext() == null) {
            head = tail = null;
        }else {
            Node<E> atual = head;
            while (atual.getNext() != tail){
                atual = atual.getNext();
            }
            tail = atual;
            tail.setNext(null);
        }
        size --;
        return true;
    }

    public E removeIndice(int indice){
        if (indice < 0 || indice >= size){
            throw new IndexOutOfBoundsException("Indice invalido.");
        }

        E elemento;

        if (indice == 0){
            elemento = head.getElement();
            removeFirst();
        } else if (indice == size - 1){
            elemento = tail.getElement();
            removeLast();
        }else {
            Node<E> referencia = head;

            for (int i = 0; i < indice - 1; i++){
                referencia = referencia.getNext();
            }
            elemento = referencia.getNext().getElement();
            referencia.setNext(referencia.getNext().getNext());
            size--;
        }

        return elemento;
    }

    public boolean removeElemento(E elemento){
        if (size == 0){return false;}

        if ((elemento == null && head.getElement() == null) || (elemento != null && elemento.equals(head.getElement()))) {
            return removeFirst();
        }

        Node<E> referencia = head;

        while (referencia.getNext() != null){
            if ((elemento == null && referencia.getNext().getElement() == null) || (elemento != null && elemento.equals(referencia.getNext().getElement()))){
                referencia.setNext(referencia.getNext().getNext());
                size--;
                return true;
            }
            referencia = referencia.getNext();
        }

        if ((elemento == null && tail.getElement() == null) || (elemento != null && elemento.equals(tail.getElement()))) {
            return removeLast();
        }

        return false;
    }


    public boolean contem(E elemento){
        Node<E> nodoAtual = head;

        while (nodoAtual != null){
            if ((elemento == null && nodoAtual.getElement() == null) || (elemento != null && elemento.equals(nodoAtual.getElement()))){
                return true;
            }
            nodoAtual = nodoAtual.getNext();
        }

        return false;
    }

    public int indiceDe(E elemento){
        Node<E> referencia = head;
        int indice = 0;

        while (referencia != null){
            if ((elemento == null && referencia.getElement() == null) || (elemento != null && elemento.equals(referencia.getElement()))){
                return indice;
            }
            referencia = referencia.getNext();
            indice++;
        }

        return -1;
    }

    public E pegar(int indice){
        if (indice < 0 || indice >= size){
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        Node<E> atual = head;
        for (int i = 0; i < indice; i++){
            atual = atual.getNext();
        }
        return atual.getElement();
    }

    public E substituir(int indice, E elemento){
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

    public int tamanho(){
        return size;
    }

    public boolean estaVazia(){
        return size == 0;
    }

    public void limpar(){
        head = null;
        tail = null;
        size = 0;
    }

    public String toString(){
        if (size == 0){
            return "[]";
        }

        String textoPrincipal = "[";
        Node<E> atual = head;

        while (atual.getNext() != null){
            textoPrincipal += atual.getElement() + ", ";
            atual = atual.getNext();
        }

        textoPrincipal += tail.getElement() + "]";
        return textoPrincipal;
    }

}
