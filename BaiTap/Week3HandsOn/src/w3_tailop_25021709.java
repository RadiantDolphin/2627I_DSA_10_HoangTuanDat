import java.util.Stack;

public class w3_tailop_25021709 {


    // Function to evaluate a postfix expression
    static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }


    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentCharacter = expression.charAt(i);

            if (Character.isWhitespace(currentCharacter)) {
                // ignore whitespace
                continue;
            }


            // if letter/number, add to postfix immediately
            if (Character.isLetterOrDigit(currentCharacter)) {
                result.append(currentCharacter);
            }

            // push open bracket
            else if (currentCharacter == '(') {
                stack.push(currentCharacter);
            }

            // closing bracket
            else if (currentCharacter == ')') {
                // pop until '(' is found or stack empty
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the '('
                }
            }

            
            else {
                // probably an operator
                while (!stack.isEmpty() && stack.peek() != '(' && priority(currentCharacter) <= priority(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(currentCharacter);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }




    public static void main(String[] args) {
        String expression = "a+b*(c/d-e)*(f+g*h)-i";
        System.out.println("Infix Expression: " + expression);
        System.out.println("Postfix Expression: " + infixToPostfix(expression));
    }
}
