package patterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class ContainsAnagram {
    /*
     * Given a string and a pattern, find all anagrams of the pattern in the given
     * string.
     * 
     * Every anagram is a permutation of a string. As we know, when we are not
     * allowed to repeat characters while finding permutations of a string, we get
     * permutations (or anagrams) of a string having characters. For example, here
     * are the six anagrams of the string abc:
     * 
     * abc
     * acb
     * bac
     * bca
     * cab
     * cba
     * Write a function to return a list of starting indices of the anagrams of the
     * pattern in the given string.
     * 
     * Example:
     * str="ppqp", pattern="pq" [p,1; q,1]
     */

    public List<Integer> hasAnagram(String s, String p) {
        List<Integer> anagram = new ArrayList<>();
        int start = 0;
        int matched = 0;
        Map<Character, Integer> patternMap = new HashMap<>();
        for (Character c : p.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }
        for (int end = 0; end < s.length(); end++) {//2,3
            Character c = s.charAt(end);
            if (patternMap.containsKey(c)) {
                patternMap.put(c, patternMap.get(c) - 1); // [p,1; q,1]
                if (patternMap.get(c) == 0) {
                    matched++;// 1,2,1,2,1,
                }
            }
            if (matched == patternMap.size()) {
                anagram.add(start);//[1,2]
            }
            if (end >= p.length() - 1) {
                Character last = s.charAt(start);
                if (patternMap.containsKey(last)) {
                    if (patternMap.get(last) == 0) {
                        matched--;
                    }
                    patternMap.put(last, patternMap.get(last) + 1);
                }
                start++;//1,2,3
            }

        }
        return anagram;

    }

}
