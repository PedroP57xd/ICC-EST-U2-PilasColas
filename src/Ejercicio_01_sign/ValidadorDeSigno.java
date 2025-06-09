package Ejercicio_01_sign;

import java.util.Stack;

public class ValidadorDeSigno {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(')');
                case '[' -> stack.push(']');
                case '{' -> stack.push('}');
                default -> {
                    if (stack.isEmpty() || stack.pop() != c)
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}