package controller;

import models.NodeGeneric;

import java.util.EmptyStackException;

import models.Node;

public class Queue {
    private Node primero; // tambien se le llama head - front
    private Node ultimo; // tambien se le llama tail - rear
    private int size; // Tamaño de la cola
    public Queue(Node primero, Node ultimo) {
        this.primero = null;
        this.ultimo = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            primero = newNode; 
            ultimo=newNode;
        } else {
            ultimo.setNext(newNode); // El último nodo apunta al nuevo nodo
            ultimo = newNode; // Actualiza el último nodo a ser el nuevo nodo
        }
        size++;
    }
    public int remove(){
        if (isEmpty()) {
            throw new  EmptyStackException();
        }
        int aux = primero.getValue(); 
        primero = primero.getNext();

        size--;
        return aux;
    }
    public int peek() {
        if(isEmpty()) throw new EmptyStackException();return primero.getValue(); // Devuelve el valor del primer nodo sin eliminarlo
    }
    public int size(){
        int count = 0;
        Node current = primero; // Comienza desde el primer nodo
        while (current != null) {
            count++; // Incrementa el contador por cada nodo
            current = current.getNext(); // Avanza al siguiente nodo
        }
        return count; // Devuelve el tamaño de la cola
    }
    public boolean isEmpty(){
        return primero == null; // Verifica si la cola está vacía
    }
}
