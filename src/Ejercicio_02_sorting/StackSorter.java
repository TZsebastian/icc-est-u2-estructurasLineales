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
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese los elementos de la pila:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            int element = Integer.parseInt(scanner.nextLine());
            stack.push(element);
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
