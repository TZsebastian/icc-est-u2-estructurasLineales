package Controllers;

import Materia.Models.Contact;
import Materia.Models.LindekList;
import Materia.Models.NodeGeneric;

public class ContactManager {
    private LindekList<Contact<?, ?>> contacts;

    public ContactManager(){
        this.contacts = new LindekList<>();
    }

    public void addContact(Contact<?, ?> contact){
        contacts.appendToTail(contact);
    }

    public void printList(){
        contacts.print();
    }
    
    public Contact<?,?> findContactByName(String name){
        NodeGeneric<Contact<?,?>> current = contacts.getHead();
        
        while(current != null){
            if(((String) current.getValue().getName()).equalsIgnoreCase(name)){
                return current.getValue();
            }
            current = current.getNext();
        }
        return null; // no se encontró un contacto 
    }

    public void deleteContactByName(String name){
        NodeGeneric<Contact<?,?>> current = contacts.getHead();

        if(current == null)
            return;

        // Caso 1 que el contacto sea la HEAD o cabeza
        if(((String) current.getValue().getName()).equalsIgnoreCase(name)){
            contacts.setHead(current.getNext());
            contacts.setSize(contacts.getSize() - 1);
            return;
        }
        // Caso 2 en el resto iterar la lista
        while(current.getNext() != null){
            if(((String)current.getNext().getValue().getName()).equalsIgnoreCase(name)){
                current.setNext(current.getNext().getNext());
                contacts.setSize(contacts.getSize() - 1);
                return;
            }
            current = current.getNext();
        }
    }
}
