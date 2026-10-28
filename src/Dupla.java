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

    public boolean removeFirst(){
        if (size == 0){return false;}

        if (head.getNext() == null){
            head = tail = null;
        }else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--;
        return true;
    }

    public boolean removeLast(){
        if (size == 0){return false;}

        if (head.getNext() == null){
            head = tail = null;
        }else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
        return true;
    }

    public E removeIndice(int posicao){
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

    public boolean removeElemento(E elemento){
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

    public boolean contem(E elemento){
        Node<E> atual = head;

        while (atual != null){
            if ((elemento == null && atual.getElement() == null) || (elemento != null && elemento.equals(atual.getElement()))){
                return true;
            }
            atual = atual.getNext();
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
