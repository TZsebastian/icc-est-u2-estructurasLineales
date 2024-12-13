package Ejercicio_02_sorting;

import Materia.Stacks.StackGeneric;
import java.util.Scanner;

public class StackSorter {

    public static void sortStack(StackGeneric<Integer> stack) {
        StackGeneric<Integer> tempStack = new StackGeneric<>();  

        while (!stack.isEmpty()) {

            int current = stack.pop();


            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                stack.push(tempStack.pop());
            }


            tempStack.push(current);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        StackGeneric<Integer> stack = new StackGeneric<>();
        

        System.out.print("Ingrese la cantidad de elementos para la pila: ");
        int n;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n > 0) break;
                System.out.println("Por favor, ingrese un número positivo.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero positivo.");
            }
        }

        System.out.println("Ingrese los elementos de la pila:");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Elemento " + (i + 1) + ": ");
                try {
                    int element = Integer.parseInt(scanner.nextLine());
                    stack.push(element);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Ingrese un número entero.");
                }
            }
        }

        System.out.println("\nPila original:");
        stack.printStackEjercicio();  

        // Ordenamos la pila
        sortStack(stack);

        System.out.println("\nPila ordenada:");
        stack.printStackEjercicio();  

        scanner.close();
    }
}