package patterns.hashmap;

import java.util.*;

/*
 * Given a string, determine the length of the longest palindrome that can be constructed using the characters from the string.
 *  You don't need to return the palindrome itself, just its maximum possible length.
 * 
 */
public class MaxPlaindromeLen {

    public int getMaxLength(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);// a,1; p,3; l,1;e,2;i,1 
        }
        int maxLength = 0;
        int oneOdd = 0;
        for (Character c : countMap.keySet()) {
            if (countMap.get(c) % 2 == 0) {
                maxLength += countMap.get(c);
            } else {
                maxLength += countMap.get(c) - 1;
                oneOdd = 1;
            }

        }
        return maxLength + oneOdd;
    }

}
