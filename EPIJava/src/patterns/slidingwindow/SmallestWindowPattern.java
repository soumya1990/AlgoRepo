package patterns.slidingwindow;

/*
 * Given a string and a pattern, find the smallest substring in the given string which has all the character occurrences of the given pattern.
 * Example: s ="aabac" p = abc
 * returns: bac
 * 
 */
import java.util.*;

public class SmallestWindowPattern {

    public String getSmallestPattern(String s, String p) {
        int start = 0;
        int matched = 0;
        String smallest = s;// aabac,abac, bac // int[] ansIdx =new int[2]; can be done // here assumption
                            // is that we patten match is always found
                            // else minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength); can be done
        Map<Character, Integer> pMap = new HashMap<>();
        for (Character c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);// [(a,0)(b,1)(c,0)]
        }
        for (int end = 0; end < s.length(); end++) {
            Character right = s.charAt(end);
            if (pMap.containsKey(right)) {
                pMap.put(right, pMap.get(right) - 1);
            }
            if (pMap.get(right) == 0) {
                matched++;
            }
            while (matched == p.length()) {
                if (end - start + 1 < smallest.length()) {
                    smallest = s.substring(start, end + 1); // can return from here if the ans length == pattern length;
                }
                // remove left
                Character left = s.charAt(start);
                if (pMap.containsKey(left)) {
                    if (pMap.get(left) == 0) {
                        matched--;
                    }
                    pMap.put(left, pMap.get(left) + 1);
                }
                start++;
            }

        }
        return smallest;
    }

}
