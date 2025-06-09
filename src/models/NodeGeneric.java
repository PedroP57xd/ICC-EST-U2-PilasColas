package models;

public class NodeGeneric<T> {
    private T value; // value del nodo genérico
    private NodeGeneric<T> next;

    public NodeGeneric(T value) {
        this.value = value; // Inicializa el value del nodo
        this.next = null; // Inicializa el siguiente nodo como nulo
    }
    

    public NodeGeneric(T value, NodeGeneric<T> next) {
        this.value = value;
        this.next = next;
    }


    public T getValue() {
        return value;
    }


    public void setValue(T value) {
        this.value = value;
    }


    public NodeGeneric<T> getNext() {
        return next;
    }


    public void setNext(NodeGeneric<T> next) {
        this.next = next;
    }

}
