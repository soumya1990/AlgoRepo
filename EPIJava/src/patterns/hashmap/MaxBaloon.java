package patterns.hashmap;

import java.util.*;

/*
 * Given a string, determine the maximum number of times the word "balloon" can be formed using the characters from the string.
 *  Each character in the string can be used only once.
 * Example 1:

Input: "balloonballoon"
Expected Output: 2
 */
public class MaxBaloon {

    public int getBaloonCount(String s) {
        String b = "baloon";
        Map<Character, Integer> countMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> baloonMap = new HashMap<>();
        for (Character c : b.toCharArray()) {
            baloonMap.put(c, baloonMap.getOrDefault(c, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        for (Character c : baloonMap.keySet()) {
            if (!countMap.containsKey(c) || baloonMap.get(c) > countMap.get(c)) {
                return 0;
            }
            int f = countMap.get(c) / baloonMap.get(c);
            min = Math.min(min, f);
        }
        return min;

    }

}
