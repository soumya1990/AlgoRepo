package patterns.monotonicstack;

import java.util.*;

/*
 * Given a non-negative integer represented as a string num and an integer k,
 *  delete k digits from num to obtain the smallest possible integer. Return this minimum possible integer as a string.
 * 
 * s "231040" k =2
 * // 23 -> 1040
 * // 23700 k =1
 * Remove k large
 * 10200 k = 1
 * // 
 * 1901042 k =4
 * 
 * 14321 k=1 k=2
 * 4321 - 321,421,431, 432
 * 1321
 * 1421
 * 1431
 * 1432
 * 
 * 1432219 k =3,2,1, 0
 * 1,2,1,9
 * 10200 k =1,0
 * 200
 * 002 k =4,3, 2, 1
 * 1901042 k =1
 * 002
 */
public class RemoveKdigits {
    public String remove(String s, int k) {
        // ToDO: edge cases
        if (k <= 0)
            return s;
        if (k >= s.length())
            return "0";
        Stack<Integer> stack = new Stack<>(); // k =10
        int del = k;
        for (int i = 0; i <= s.length(); i++) {
            int v = i < s.length() ? Integer.parseInt(s.charAt(i) + "") : 0;
            while (!stack.isEmpty() && stack.peek() > v && del > 0) {
                stack.pop();
                del--;
            }
            if (i < s.length()) {
                stack.push(v);
            }
        }
        // if del > 0 then increasing order hence remove del items from end
        StringBuilder sb = new StringBuilder();
        for (int digit : stack) {

            if (digit == 0 && sb.length() == 0) {
                // avoid extra 0s at the begining
                continue;
            }
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
