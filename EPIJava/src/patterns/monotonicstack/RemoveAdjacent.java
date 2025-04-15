package patterns.monotonicstack;

import java.util.*;
/*You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.
 * 
 * 
 * Example fooobar -> fobar
 */
public class RemoveAdjacent {
    public String removeEquals(String s) {
        Stack<Character> stack = new Stack<>();// f,o,b,a,r
        for (int i = 0; i<s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)){
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
