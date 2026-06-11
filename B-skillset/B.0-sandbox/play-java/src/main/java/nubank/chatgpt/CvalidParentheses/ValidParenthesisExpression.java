package nubank.chatgpt.CvalidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * ByteByteGo > 07 Stacks > ValidParenthesesExpression
 *
 */
public class ValidParenthesisExpression {

    public static void main(String[] args) {
        String s = "([]{})"; // Output: true
//        String s = "([]{)}"; // Output: false

        System.out.println("Input: s = '" + s + "'");
        ValidParenthesisExpression test = new ValidParenthesisExpression();
        System.out.println("Output: " + test.valid_parenthesis_expression(s));
        System.out.println("Output: " + test.validParenthesisExpressionAJ(s));
        System.out.println("Output: " + test.validParenthesisExpressionChatGPTFix(s));
    }

    public boolean validParenthesisExpressionChatGPTFix(String s) {

        // (3) HashMap<k:opening, v:closing> - a way to manage 3 types of parentheses to ensure the comparison is correct on opening and closing parentheses.
        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('(', ')');
        parenthesesMap.put('[', ']');
        parenthesesMap.put('{', '}');

        // (1) first we extract the characters of the string `s`
        char[] chArr = s.toCharArray();

        // (5) we need to store opening parentheses and if it is closing parentheses, it should be a pair to the most recent opening parentheses, it is always at the top of the stack.
        Stack<Character> stack = new Stack<>();

        // (2) we loop the character array:
        for (char c : chArr) {
            // (4) `HashMap` can use as a lookup to check whether it is opening or closing one. it's an opening parentheses if it exists in the hash map as a key
            if (parenthesesMap.containsKey(c)) {
                // (6) push the current character if it is opening parentheses onto the stack.
                stack.push(c);
            }
            // (7) Otherwise, it's closing parentheses if it exists in the hash map as a Value instead. We only constrain to open and closed parentheses. (3) HashMap<k:opening, v:closing>
            else {
                // (A) Fix bug - peeking is too early, when the stack is empty, `peek()` will throw an exception before `!stack.isEmpty()` check.
                if (stack.isEmpty()) return false;

                // (8) but before we are popping out, take a 'peek' - it Returns the element at the top of the stack without removing it.
                Character peeking = stack.peek(); // (8) we expect peeking at the top of the stack is an opening parentheses that pairs the closing parentheses character while looping the character array.
                // (9) pop the current character which is the closing parentheses by checking if it is a pair to the most recent opening parentheses.
                // (12) Edge case #2: We might also consider that fact that we are peeking at the top of the stack to not be empty. but if so, we just return false. We need to add an empty stack checker guardrail
                if (parenthesesMap.get(peeking) == c) { // (10) a `c` is expected to be a closing parentheses here.
                    stack.pop();
                }
            }
        }

        // (11) Edge case #1: extra opening parentheses - We only check for invalidity at closing parenthesis, so need to perform a final check to ensure there aren’t any opening parentheses in the string left unclosed. This can be done by checking if the stack is empty after processing the whole input string, as a non-empty stack indicates opening parentheses remain in the stack.
        return stack.isEmpty();
    }

    public boolean validParenthesisExpressionAJ(String s) {

        // (3) HashMap<k:opening, v:closing> - a way to manage 3 types of parentheses to ensure the comparison is correct on opening and closing parentheses.
        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('(', ')');
        parenthesesMap.put('[', ']');
        parenthesesMap.put('{', '}');

        // (1) first we extract the characters of the string `s`
        char[] chArr = s.toCharArray();

        // (5) we need to store opening parentheses and if it is closing parentheses, it should be a pair to the most recent opening parentheses, it is always at the top of the stack.
        Stack<Character> stack = new Stack<>();

        // (2) we loop the character array:
        for (char c : chArr) {
            // (4) `HashMap` can use as a lookup to check whether it is opening or closing one. it's an opening parentheses if it exists in the hash map as a key
            if (parenthesesMap.containsKey(c)) {
                // (6) push the current character if it is opening parentheses onto the stack.
                stack.push(c);
            }
            // (7) Otherwise, it's closing parentheses if it exists in the hash map as a Value instead. We only constrain to open and closed parentheses. (3) HashMap<k:opening, v:closing>
            else {
                // (8) but before we are popping out, take a 'peek' - it Returns the element at the top of the stack without removing it.
                Character peeking = stack.peek(); // (8) we expect peeking at the top of the stack is an opening parentheses that pairs the closing parentheses character while looping the character array.
                // (9) pop the current character which is the closing parentheses by checking if it is a pair to the most recent opening parentheses.
                // (12) Edge case #2: We might also consider that fact that we are peeking at the top of the stack to not be empty. but if so, we just return false. We need to add an empty stack checker guardrail
                if (!stack.isEmpty() && parenthesesMap.get(peeking) == c) { // (10) a `c` is expected to be a closing parentheses here.
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        // (11) Edge case #1: extra opening parentheses - We only check for invalidity at closing parenthesis, so need to perform a final check to ensure there aren’t any opening parentheses in the string left unclosed. This can be done by checking if the stack is empty after processing the whole input string, as a non-empty stack indicates opening parentheses remain in the stack.
        return stack.isEmpty();
    }

    public Boolean valid_parenthesis_expression(String s) {
        HashMap<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('(', ')');
        parenthesesMap.put('{', '}');
        parenthesesMap.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // If the current character is an opening parenthesis, push it onto the stack.
            if (parenthesesMap.containsKey(c)) {
                stack.push(c);
            }
            // If the current character is a closing parenthesis, check if it closes the
            // opening parenthesis at the top of the stack.
            else {
                if (!stack.isEmpty() && parenthesesMap.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        // If the stack is empty, all opening parentheses were successfully closed.
        return stack.isEmpty();
    }
}

