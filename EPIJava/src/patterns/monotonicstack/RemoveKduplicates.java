package patterns.monotonicstack;

import java.util.*;

/*
 * ou are given a string s and an integer k. Your task is to remove groups of identical, consecutive characters from the string such that each group has exactly k characters. The removal of groups should continue until it's no longer possible to make any more removals. 
 * The result should be the final version of the string after all possible removals have been made.
 * 
 * Example: s = "abbbaaca", k = 3
 */
public class RemoveKduplicates {
    class Pair {
        Character key;
        int count;
        Pair(Character key, int count) {
            this.key = key;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {// "abbaccaa" k=3
        Stack<Pair> stack = new Stack<>();// a,1;b,2;a,1;c,2;a,2
       
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(new Pair(c, 1));
            } else {
                if (c != stack.peek().key) {
                    stack.push(new Pair(c, 1));
                } else {
                    stack.peek().count++;
                    if (stack.peek().count == k) {
                       stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair c : stack) {
            for (int i = 0; i<c.count; i++) {
                sb.append(c.key);
            }
        }
        return sb.toString();
    }

}
