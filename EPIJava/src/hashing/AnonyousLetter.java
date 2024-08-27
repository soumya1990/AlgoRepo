package hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnonyousLetter {

    /**
     * There is a magazine letters and an anonymous letter.
     * Return true if the magazine letters can be used to write the anonymous
     * letter.
     * TC = O(m+n) SC = O(m)
     * to reduce the space complexity here is the alternative approach:
     * 1. Create a hashmap of Letters,
     * 2. take each letters from the magazine - if it is present in letter dict then
     * decrement the count and delete if count is 0
     * 3. if the letter hashmap is empty return true
     * 4. On exit from loop if hashmap is empty then return true else false;
     */

    public boolean isAnonymousLetterFeasible(String mag, String letter) {
        Map<Character, Integer> magDict = new HashMap<>();
        for (int i = 0; i < mag.length(); i++) {
            int count = magDict.getOrDefault(mag.charAt(i), 0);
            magDict.put(mag.charAt(i), count + 1);
        }
        for (int i = 0; i < letter.length(); i++) {
            int count = magDict.getOrDefault(letter.charAt(i), 0);
            if (count <= 0)
                return false;
            magDict.put(letter.charAt(i), --count);
        }
        return true;
    }

    /**
     * Space optimized
     */
    public boolean isAnonymousFeasible(String letter, String mag) {
        Map<Character, Integer> freqDict = new HashMap<>();
        for (int i = 0; i < letter.length(); i++) {
            int count = freqDict.getOrDefault(letter.charAt(i), 0);
            freqDict.put(letter.charAt(i), count + 1);
        }
        for (int i = 0; i < mag.length(); i++) {
            if (freqDict.containsKey(mag.charAt(i))) {
                int f = freqDict.get(mag.charAt(i));
                // System.out.println("contains " + mag.charAt(i)+ "freq = "+ f);
                f--;
                if (f == 0) {
                    freqDict.remove(mag.charAt(i));
                    // System.out.println("remove = "+mag.charAt(i));
                } else {
                    freqDict.put(mag.charAt(i), f);
                }
                if (freqDict.isEmpty()) {
                    return true;
                }
            }
        }
        if (freqDict.isEmpty()) {
            return true;
        }

        return false;

    }
}
