package controller;

import java.util.EmptyStackException;

import models.Node;

public class Stack {
    private Node top; // Nodo cima de la pila
    private int size; // Tamaño de la pila

    public Stack() {
        this.top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.setNext(top); // El nuevo nodo apunta al nodo actual en la cima
        top = newNode;
        size++; // Incrementa el tamaño de la pila
    }

    public int pop() {
        if (top == null) {
            throw new EmptyStackException();

        }
        int value = top.getValue(); // Obtiene el valor del nodo en la cima
        top = top.getNext(); // Elimina el nodo de la cima
        size--; // Decrementa el tamaño de la pila
        return value;
    }

    public int peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.getValue(); // Devuelve el valor del nodo en la cima sin eliminarlo
    }

    public boolean isEmpty() {
        return top == null; // Verifica si la pila está vacía
    }

    public void print() {
        Node current = top; // Comienza desde la cima de la pila

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
