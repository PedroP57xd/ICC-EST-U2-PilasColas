package controller;

import java.util.EmptyStackException;

import models.Node;
import models.NodeGeneric;

public class StackG<T> {
    private NodeGeneric<T> top;
    private int size;

    public StackG() {
        this.top = null;
        this.size = 0;
    }

    public void push(int value) {
        NodeGeneric<T> newNode = new NodeGeneric(value);
        newNode.setNext(top); // El nuevo nodo apunta al nodo actual en la cima
        top = newNode;
        size++; // Incrementa el tamaño de la pila
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();

        }
        T value = top.getValue(); // Obtiene el valor del nodo en la cima
        top = top.getNext(); // Elimina el nodo de la cima
        size--;
        return value;// Decrementa el tamaño de la pila
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.getValue(); // Devuelve el valor del nodo en la cima sin eliminarlo
    }

    public boolean isEmpty() {
        return top == null; // Verifica si la pila está vacía
    }

    public void print() {
        NodeGeneric<T> current = top; // Comienza desde la cima de la pila

        while (current != null) {
            System.out.print(current.getValue() + " | "); // Imprime el valor del nodo actual
            current = current.getNext(); // Avanza al siguiente nodo
        }
        System.out.println(); // Nueva línea al final de la impresión
    }

    public int size() {
        return size; // Devuelve el tamaño actual de la pila
    }
}
