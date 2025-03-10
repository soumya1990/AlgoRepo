/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.
 * 
 * Option 1: sort s, sort t, if equal anagram - TC : O(NlgN), SC = O(N)
 * Option 2: Map reduction- populate count Map with s and reduce count Map with t. 
 *              If values of all keys in the count Map is 0 then it's an ANagram
 *              TC = O(N) SC = O(N)
 */
package patterns.warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = s.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        String s1 = new String(sArr);
        String s2 = new String(tArr);
        return s1.equals(s2);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Character key = t.charAt(i);
            if (countMap.containsKey(key)) {
                int f = countMap.get(key);
                if (f == 0)
                    return false;
                countMap.put(key, f - 1);
            } else {
                return false;
            }
        }

        for (Character key : countMap.keySet()) {
            if (countMap.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

}
