import java.util.Stack;

import Ejercicio_01_sign.ValidadorDeSigno;
import Ejercicio_02_sorting.StackOrdenamiento;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println(" Ejercicio 01: Validación de Signos \n");
        String input1 = "([]){}";
        String input2 = "({)}";
        System.out.println(input1 + " = " + ValidadorDeSigno.isValid(input1));
        System.out.println(input2 + " = " + ValidadorDeSigno.isValid(input2));

        System.out.println("\n Ejercicio 02: Ordenar un Stack \n" + //
                "");
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Stack original:  5 | 1 | 4 | 2 |");
        StackOrdenamiento.sortStack(stack);
        System.out.print("Stack ordenado:  ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " | ");
        }
        System.out.println("\n");
    }
}
