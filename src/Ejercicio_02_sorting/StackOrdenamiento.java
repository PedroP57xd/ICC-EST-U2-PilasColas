package Ejercicio_02_sorting;
import java.util.Stack;

public class StackOrdenamiento {
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        // Copiar de vuelta al stack original si se requiere
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

}