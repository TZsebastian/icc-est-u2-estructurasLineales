package Controllers;

import Materia.Models.Contact;
import Materia.Models.LindekList;

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
}
