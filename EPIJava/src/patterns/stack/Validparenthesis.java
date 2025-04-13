package patterns.stack;

import java.util.*;
/*Given a string s containing (, ), [, ], {, and } characters. 
Determine if a given string of parentheses is balanced.

A string of parentheses is considered balanced if every opening parenthesis has a corresponding 
closing parenthesis in the correct order. 
Example: "{[()]}";
*/

public class Validparenthesis {

    public boolean isValidParenthesis(String exp) {
        LinkedList<Character> stack = new LinkedList<>();
        for (Character c : exp.toCharArray()) {// {[()]}
            if (isOpen(c)) {
                stack.push(c);// {, [, (
            } else {
                if (stack.isEmpty() || !matches(c, stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            }

        }
        return stack.isEmpty();
        

    }

    private boolean isOpen(Character c) {
        if (c == '{' || c == '[' || c == '(') {
            return true;
        } else {
            return false;
        }
    }

    private boolean matches(Character c, Character o) {
        if (o == '{' && c == '}')
            return true;
        if (o == '[' && c == ']')
            return true;
        if (o == '(' && c == ')')
            return true;
        return false;

    }

}
