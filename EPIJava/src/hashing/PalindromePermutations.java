package hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PalindromePermutations {
    /**
     * Given a string return true if a palindrome can be formed from any angram of
     * it.
     */
    public boolean isAnagramPalindrome(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        char[] sArr = s.toCharArray();
        for (Character c : sArr) {
            int f = dict.getOrDefault(c, 0);
            dict.put(c, ++f);
        }
        Iterator<Character> it = dict.keySet().iterator();
        int oddCount = 0;
        while (it.hasNext()) {
            char key = it.next();
            if (dict.get(key) % 2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
