package Materia.Models;

public class LindekList <T> {
    private NodeGeneric<T> head;
    private int size = 0;

    public void appendToTail(T value){
        if(head == null){
            head = new NodeGeneric<>(value);
        } else{
            NodeGeneric<T> current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(new NodeGeneric<>(value));
        }
        size++;
    }

    public void print (){
        if(head == null){
            System.out.println("End");
            return;
        }
        NodeGeneric<T> current = head;
        while(current.getNext() != null){
            System.out.println(current.getValue() + " -> ");
            current = current.getNext();
        }
        System.out.println(current.getValue());
        System.out.println("End");
    }

}
