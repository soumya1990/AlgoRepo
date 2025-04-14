package patterns.stack;

import java.util.*;
/*
 * Given a positive integer n, write a function that returns its binary equivalent as a string.
 * The function should not use any in-built binary conversion function
 * 
 * Example = 7
 * 110
 * 
 */

public class DecimalToBin {

    public String decimalTobin(int num) {
        if (num == 0) {
            return new String("0");
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (num > 0) {
            int r = num % 2;
            res.push(r); // 1000
            num = num / 2;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer n : res) {
            sb.append(n);
        }
        return sb.toString();

    }
}
