package Ejercicio_01_sign;

import Materia.Stacks.StackGeneric;  
import java.util.Scanner;

public class SignValidator {

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("-------------");
            System.out.println("Menú de Validación de Signos");
            System.out.println("1. Validar cadena de signos");
            System.out.println("2. Salir");

            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    validateInput(scanner);
                    break;
                case "2":
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    private void validateInput(Scanner scanner) {
        System.out.print("Ingrese una cadena de caracteres para validar: ");
        String input = scanner.nextLine();
        boolean isValid = isValid(input);
        System.out.println("Resultado: " + (isValid ? "Válido" : "Inválido"));
    }

    public static boolean isValid(String input) {
        StackGeneric<Character> stack = new StackGeneric<>();  
    
        for (char c : input.toCharArray()) {
            if (c == '{') {
                stack.push(c); 
            } else if (c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();  
            }
        }
        return stack.isEmpty();  
    }
}    