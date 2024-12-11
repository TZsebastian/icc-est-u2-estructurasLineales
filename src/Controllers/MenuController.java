package Controllers;

import java.util.List;

import Materia.Models.Contact;
import Views.ConsoleView;


public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController() {
        this.contactManager = new ContactManager();
        this.consoleView = new ConsoleView();
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            consoleView.displayMenu();
            String option = consoleView.getInput("Select an option: ");
            switch (option) {
                case "1":
                    addContact();
                    break;
                case "2":
                    findContactByName();
                    break;
                case "3":
                    deleteContactByName();
                    break;
                case "4":
                    printList();
                    break;
                case "5":
                    exit = true;
                    consoleView.showMessage("Exitinzg...");
                    break;
                default:
                    consoleView.showMessage("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void addContact() {
        String name = consoleView.getInput("Enter name: ");
        String phone = consoleView.getInput("Enter phone: ");
        Contact<String, String> contact = new Contact<>(name, phone);
        contactManager.addContact(contact);
        consoleView.showMessage("Contact added");
    }

    private void findContactByName() {
        String name = consoleView.getInput("Enter a name to search");
        Contact<?,?> contact = contactManager.findContactByName(name);
        if(contact != null){
            consoleView.showMessage("Contact found: " + contact);
        } else{
            consoleView.showMessage("Contact not found 404");
        }
    }

    private void deleteContactByName() {
        String name = consoleView.getInput("Enter a name to delete: ");
        contactManager.deleteContactByName(name);
        consoleView.showMessage("Contact deleted if it ex");
    }

    private void printList() {
        contactManager.printList();
    }
}