package Ejercicio_02_sorting;

import Materia.Stacks.StackGeneric;
import java.util.Scanner;

public class Ejercicio02 {

    // Método para ordenar el Stack
    public static void sortStack(StackGeneric<Integer> stack) {
        StackGeneric<Integer> tempStack = new StackGeneric<>();  // Pila adicional

        while (!stack.isEmpty()) {
            // Sacamos un elemento de la pila original
            int current = stack.pop();

            // Movemos los elementos de la pila adicional a la pila original si son mayores que el actual
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                stack.push(tempStack.pop());
            }

            // Colocamos el elemento actual en la pila adicional
            tempStack.push(current);
        }

        // Finalmente, la pila original contiene los elementos ordenados
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    // Método que gestiona la interacción con el usuario para ordenar la pila
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        StackGeneric<Integer> stack = new StackGeneric<>();
        
        // Solicitar al usuario que ingrese la cantidad de elementos
        System.out.print("Ingrese la cantidad de elementos para la pila: ");
        int n = Integer.parseInt(scanner.nextLine());

        // Solicitar al usuario que ingrese los elementos
        System.out.println("Ingrese los elementos de la pila:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            int element = Integer.parseInt(scanner.nextLine());
            stack.push(element);
        }

        System.out.println("\nPila original:");
        stack.printStackEjercicio();  // Usamos el printStackWithArrows para la pila original

        // Ordenamos la pila
        sortStack(stack);

        System.out.println("\nPila ordenada:");
        stack.printStackEjercicio();  // Usamos el printStackWithArrows para la pila ordenada

        scanner.close();
    }
}
