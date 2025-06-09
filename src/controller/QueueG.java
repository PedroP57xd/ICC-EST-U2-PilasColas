package controller;
import java.util.EmptyStackException;

import models.Node;
import models.NodeGeneric;
import models.Persona;
public class QueueG <T>{
    private NodeGeneric<T> primero;
    private NodeGeneric<T> ultimo;
    private int size;

    public QueueG() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }
        public void add(Persona p1) {
        NodeGeneric<T> newNode = new NodeGeneric(p1);
        if (isEmpty()) {
            primero = newNode; 
            ultimo=newNode;
        } else {
            ultimo.setNext(newNode); // El último nodo apunta al nuevo nodo
            ultimo = newNode; // Actualiza el último nodo a ser el nuevo nodo
        }
        size++;
    }
    public T remove(){
        if (isEmpty()) {
            throw new  EmptyStackException();
        }
        T aux = primero.getValue(); 
        primero = primero.getNext();

        size--;
        return aux;
    }
    public T peek() {
        if(isEmpty()) throw new EmptyStackException();return primero.getValue(); // Devuelve el valor del primer nodo sin eliminarlo
    }
    public int size(){
        int count = 0;
        NodeGeneric<T> current = primero; // Comienza desde el primer nodo
        while (current != null) {
            count++; // Incrementa el contador por cada nodo
            current = current.getNext(); // Avanza al siguiente nodo
        }
        return count; // Devuelve el tamaño de la cola
    }
    public boolean isEmpty(){
        return primero == null; // Verifica si la cola está vacía
    }
    public void printCola(){
        NodeGeneric<T> current = primero; // Comienza desde el primer nodo

        while (current != null) {
            System.out.print(current.getValue() + " | "); // Imprime el valor del nodo actual
            current = current.getNext(); // Avanza al siguiente nodo
        }
        System.out.println(); // Nueva línea al final de la impresión
    } 
    public void findByName(String name) {
        NodeGeneric<T> current = primero; // Comienza desde el primer nodo
        boolean found = false; // Bandera para verificar si se encontró el nombre

        while (current != null) {
            if (current.getValue() instanceof Persona) {
                Persona persona = (Persona) current.getValue();
                if (persona.getNombre().equals(name)) {
                    System.out.println("Persona encontrada: " + persona);
                    found = true;
                    break; // Sale del bucle si se encuentra la persona
                }
            }
            current = current.getNext(); // Avanza al siguiente nodo
        }

        if (!found) {
            System.out.println("No se encontró ninguna persona con el nombre: " + name);
        }
    }
        NodeGeneric<T> current = primero; // Comienza desde el primer nodo
        String name = "John"; // Nombre a buscar, puedes cambiarlo según sea necesario

        while (current != null) {
            if (current.getValue() instanceof Persona) {
                Persona persona = (Persona) current.getValue();
                if (persona.getNombre().equals(name)) {
                    System.out.println("Found: " + persona);
                    return; // Sale del método si encuentra la persona
                }
            }
            current = current.getNext(); // Avanza al siguiente nodo
        }
        System.out.println("Persona with name " + name + " not found.");
    }
    public Persona deleteByName(String name) {
        NodeGeneric<T> current = primero; // Comienza desde el primer nodo
        NodeGeneric<T> previous = null; // Nodo anterior para mantener la referencia

        while (current != null) {
            if (current.getValue() instanceof Persona) {
                Persona persona = (Persona) current.getValue();
                if (persona.getNombre().equals(name)) {
                    if (previous == null) {
                        // Si es el primer nodo
                        primero = current.getNext(); // Actualiza el primero
                    } else {
                        previous.setNext(current.getNext()); // Elimina el nodo actual
                    }
                    if (current == ultimo) {
                        ultimo = previous; // Actualiza el último si es necesario
                    }
                    size--; // Decrementa el tamaño de la cola
                    System.out.println("Deleted: " + persona);
                    return; // Sale del método después de eliminar
                }
            }
            previous = current; // Mueve el nodo anterior al actual
            current = current.getNext(); // Avanza al siguiente nodo
        }
        System.out.println("Persona with name " + name + " not found.");
    }
}
