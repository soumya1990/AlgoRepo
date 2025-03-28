package patterns.slidingwindow;

import java.util.*;

/*
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, 
 * find the length of the longest substring having the same letters after replacement
 * 
 * example: 
 * [abacbba] k=2
 * ALgo:
 * Expand window till the length till same letter with k replacement condition satisfies.
 * How? Exclude the max frequency letter and aggregate count of rest should be <= k
 * 
 * Option 1: sorted map with value ?
 * Option 2: linear search to find  O(L*26)
 * Option 3: We can notice that the maxFrequency in a sliding window will be the max of incoming(right)'s freqency' or the exising max freqency
 * 
 */
public class LongestWithReplacement {

    // [abacbba] k=2
    // O(L*26)
    public int getLongest(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>(); // [(a,1), (b,2), (c, 1))]
        int longest = 0;
        int start = 0;
        int maxFreq = 0;
        for (int end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, countMap.get(c));
            while (/* (option 2)!isValidWindow(countMap, k) */ end - start + 1 - maxFreq > k) {
                Character f = s.charAt(start);
                countMap.put(f, countMap.get(f) - 1);
                if (countMap.get(f) == 0) {
                    countMap.remove(f);
                }
                start++;
            }
            longest = Math.max(longest, end - start + 1);
        }
        return longest;
    }

    // Option 2
    private boolean isValidWindow(Map<Character, Integer> countMap, int k) {
        int maxF = 0;
        int sum = 0;
        for (Character c : countMap.keySet()) {
            int freq = countMap.get(c);
            sum += countMap.get(c);
            maxF = Math.max(maxF, freq);
        }
        sum -= maxF;
        return sum <= k ? true : false;
    }

}
