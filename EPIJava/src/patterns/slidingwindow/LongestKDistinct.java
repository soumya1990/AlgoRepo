package patterns.slidingwindow;

import java.util.*;

/*
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
You can assume that K is less than or equal to the length of the given string.
 * 
 * Example: 
 * "apple" K = 2
 * -> 3 -> "app"
 */
public class LongestKDistinct {

    public int getLongestWithDistinct(String s, int K) { // "apple", 2
        int start = 0;// 0, 1, 2
        Map<Character, Integer> countMap = new HashMap<>();
        int longest = Integer.MIN_VALUE;
        for (int end = 0; end < s.length(); end++) { // 0, 1, 2, 3, 4
            Character c = s.charAt(end);// a, p, p, l, e
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            if (countMap.keySet().size() <= K) { // 2==2;3<=2(NO) , NO
                longest = Math.max(longest, end - start + 1); // 1, 2, 3,
            }
            while (countMap.keySet().size() > K) {// 3>2 2>2 N0, 3>2
                int f = countMap.get(s.charAt(start));
                f--;
                if (f <= 0) {
                    countMap.remove(s.charAt(start));
                } else {
                    countMap.put(s.charAt(start), f);
                }
                start++;
            }
        }
        return longest;
    }
    /*
     * TestCase {a, 1} -> 1
     * {aaaaa, 1} ->
     * 
     */

}
