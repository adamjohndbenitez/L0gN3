package citi.karat.Dstack;

import java.util.Stack;

/**
 * https://www.educative.io/courses/lta/data-structures-coding-interviews-java/challenge-valid-parentheses
 * Statement:
 * Given a string, exp, which may consist of opening and closing parentheses. Your task is to check whether or not the string contains valid parenthesization.
 * The conditions to validate are as follows:
 * Every opening parenthesis should be closed by the same kind of parenthesis. Therefore, {) and [(]) strings are invalid.
 * Every opening parenthesis must be closed in the correct order. Therefore, )( and ()(() are invalid.
 * Constraints:
 * 1 ≤ exp.length ≤ 10^3
 * The string will only contain the following characters: (, ), [, ], {, and }.
 *
 * Complexity analysis
 * Let’s look at the time and space complexity of this solution:
 *
 * Time complexity
 * The time complexity of this solution is O(n), where n is the length of the expression.
 *
 * Space complexity
 * The space complexity of this solution is O(n) , where n is the length of the expression.
 */
public class AValidParentheses {
    public static boolean isBalanced(String exp) {
        // 1. We start by creating an empty stack, stack. This stack will keep track of opening parentheses as we encounter them in the string.
        Stack<Character> stack = new Stack<>();

        // 2. We then iterate through each character in exp. For this step, we consider two main actions:
        for (int i = 0; i < exp.length(); i++) {
            char character = exp.charAt(i);

            // 2.II. Upon encountering a closing parenthesis ) or } or ], we check the stack:
            if (character == '}' || character == ')' || character == ']') {
                // 2.II.i If the stack is empty, this means that there’s no opening parenthesis available to match the closing one, indicating that the parentheses are unbalanced. We return FALSE in this scenario.
                if (stack.isEmpty()) {
                    // If the stack is empty, there's no opening bracket to match with, so the expression is unbalanced
                    return false;
                }

                // 2.II.ii If the stack is not empty, we pop an element of the stack. This popped element should be the opening parenthesis corresponding to the closing one we’re currently processing. If they don’t match, we return FALSE.
                // Pop the top element from the stack (most recent opening bracket)
                char topChar = stack.pop();

                if ((character == '}' && topChar != '{') ||
                        (character == ')' && topChar != '(') ||
                        (character == ']' && topChar != '[')) {
                    return false;
                }
            } else {
                // 2.I. Whenever we encounter an opening parenthesis ( or { or [, we push it onto the stack.
                // If the character is not a closing bracket, push it onto the stack
                stack.push(character);
            }
        }

        // 3. After completing the iteration over exp, we perform one last check:
        // 3.I. If the stack is empty, every opening parenthesis has been successfully matched with a closing parenthesis. Thus, the parentheses exp are balanced, and we return TRUE.
        // 3.II. Otherwise, we return FALSE because stack contains opening parentheses without corresponding closing parentheses.
        // If stack is not empty, stack contains unmatched opening parentheses
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] parentheses = {
                "(){}[]",
                "[{()}]",
                "]}){{()}({[",
                "[[{{((}])}])",
                "))))))"
        };

        for (int i = 0; i < parentheses.length; i++) {
            System.out.println((i + 1) + ".\tCheck balanced parentheses: '" + parentheses[i] + "'");
            boolean result = isBalanced(parentheses[i]);

            System.out.println("\tIs the string balanced? " + (result ? "True" : "False"));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

class AValidParenthesesAJKarat {
    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");
        String[] parenthesis = {
                "(){}[]",
                "[{()}]",
                "]}){{()}({[",
                "[[{{((}])}])",
                "))))))"
        };

        AValidParenthesesAJKarat solution = new AValidParenthesesAJKarat();
        for (int i = 0; i < parenthesis.length; i++) {
            System.out.println((i + 1) + ".\tCheck balanced parenthesis: '" + parenthesis[i] + "'");
            boolean result = solution.isBalanced(parenthesis[i]);
            System.out.println("\tIs the string blanaced? " + (result ? "True" : "False"));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char topChar = stack.pop();
                    if ((ch == '}' && topChar != '{') || (ch == ')' && topChar != '(') || (ch == ']' && topChar != '[')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}