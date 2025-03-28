package patterns.slidingwindow;

import java.util.*;

/*
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters, it will have n! permutations.
 * 
 * example
 * cdbabacd p = abc
 */
public class ContainsPermutation {

    public boolean hasPermutation(String s, String p) {
        Map<Character, Integer> patternMap = new HashMap<>();
        Set<Character> patternKeys = new HashSet<>();
        for (int i = 0; i < p.length(); i++) {
            Character c = p.charAt(i);
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
            patternKeys.add(c);
        }
        int start = 0;
        int end = 0;
        for (end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            if (patternMap.containsKey(c)) {
                patternMap.put(c, patternMap.get(c));
                if (patternMap.get(c) == 0) { // Suggestion: Do not remove , keep a matched count
                    patternMap.remove(c); // matched++
                }
            }
            if (patternMap.keySet().size() == 0) { // matched == patternMap.keySet().size()
                return true;
            }

            if (end - start + 1 > p.length()) {
                Character fC = s.charAt(start);
                if (patternKeys.contains(fC)) { // patternsKey is not needed if we do not remove any Key
                    patternMap.put(fC, patternMap.getOrDefault(fC, 0) + 1);// if frequency is 0 then matched--
                }
                start++;
            }
        }
        return false;
    }

}
