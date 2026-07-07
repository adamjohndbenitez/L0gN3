package citi.karat.XReview;

import java.util.Stack;

public class BValidParenthesesMemorizeNoLooking {
    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");

        String[] parentheses = {
                "(){}[]",
                "[{()}]",
                "{[}",
                "[}]",
        };

        for (int i = 0; i < parentheses.length; i++) {
            System.out.println((i+1) + "\tCheck balanced parentheses: '" + parentheses[i] + "'");
            boolean result = isBalanced0(parentheses[i]);
            System.out.println("\tIs the string balance: " + result);
            System.out.println("---------------------------------");
        }
    }

    private static boolean isBalanced(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char ch = parentheses.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char topCh = stack.pop(); // remove the top and get it.
                    if ((ch == '}' && topCh != '{') ||
                            (ch == ')' && topCh != '(') ||
                            (ch == ']' && topCh != '[')
                    ) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isBalanced0(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char ch = parentheses.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char topCh = stack.pop(); // remove top of stack then get the char that was remove so we can double check if its paired / balanced
                    if ((ch == '{' && topCh != '}') ||
                            (ch == '(' && topCh != ')') ||
                            (ch == '[' && topCh != ']')
                    ) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean isBalanced1(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char ch = parentheses.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char topCh = stack.pop();
                    if ( (ch == '{' && topCh != '}') ||
                            (ch == '(' && topCh != ')') ||
                            (ch == '[' && topCh != ']')
                    ) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty(); // we return empty stack because we are going to pop / remove the top once we have a pair. if all characters are paired, it gives as an empty stack.
    }
}

