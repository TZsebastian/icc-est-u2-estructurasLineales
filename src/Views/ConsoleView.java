package Views;


import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView(){
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu(){
        System.out.println("--- Contact Manager Menu ---");
        System.out.println("/t1. Add Contact");
        System.out.println("/t2. FindContact");
        System.out.println("/t3. Delete Contact");
        System.out.println("/t4. Print Contact");
        System.out.println("/t5. Exit"); 
        System.out.println("Choose an option");
    }

    public String getInput(String prompt){
        System.out.println("* " + prompt);
        return scanner.nextLine();
    }

    public void showMessage(String message){
        System.out.println("-- " + message);
    }
}
