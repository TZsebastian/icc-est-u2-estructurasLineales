package Materia.Stacks;

import java.util.EmptyStackException;

import Materia.Models.NodeGeneric;
public class StackGeneric <T> {
    
    private NodeGeneric<T> top; 
    private int size;

    // Crea una pila instanciando el nodo top como null y el tamaño en 0 
    public StackGeneric(){
        this.top = null;
        this.size = 0;
    }

    public void push (T data) {
        NodeGeneric<T> newNode = new NodeGeneric<> (data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public boolean isEmpty(){
        return top == null;
    }
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    public void printStack() {
        NodeGeneric<T> current = top;
        while(current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public void printStackEjercicio() {
        NodeGeneric<T> current = top;
        if (current != null) {
            // Imprimir el primer elemento sin flecha
            System.out.print(current.getValue());
            current = current.getNext();
    
            // Imprimir los demás elementos con flecha
            while (current != null) {
                System.out.print("->" + current.getValue());
                current = current.getNext();
            }
        } else {
            System.out.println("La pila está vacía.");
        }
        System.out.println();  
    }

    public NodeGeneric<T> peekNode() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top;  // Retorna el nodo en la cima de la pila
    }

    public int getSize(){
        int cont = 0;
        NodeGeneric<T> current = top;
        while(current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }

    public int getSize2(){
        return size;
    }

    public NodeGeneric<T> popNode() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        NodeGeneric<T> value = top;
        top = top.getNext();
        size--;
        return value;
    }
}

