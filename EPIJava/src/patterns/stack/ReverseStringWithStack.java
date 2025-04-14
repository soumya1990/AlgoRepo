package patterns.stack;

import java.util.*;

/*
 * Given a string, write a function that uses a stack to reverse the string. The function should return the reversed string.
 * Input = "Hello"
 * Output = "olleH"
 */
public class ReverseStringWithStack {

    public String reverse(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
