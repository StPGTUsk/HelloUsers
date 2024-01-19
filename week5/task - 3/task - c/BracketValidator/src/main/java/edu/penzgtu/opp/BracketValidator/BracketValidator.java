package edu.penzgtu.opp.BracketValidator;

import java.util.Stack;

public class BracketValidator {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if ((c == ')' && last != '(') || (c == ']' && last != '[') || (c == '}' && last != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "{}[]()";
        System.out.println("Строка \"" + input + "\" валидна? " + isValid(input));
    }
}
