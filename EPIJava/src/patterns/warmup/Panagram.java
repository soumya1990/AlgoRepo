/*
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing English letters (lower or upper-case), return true if sentence is a pangram, or false otherwise.
Note: The given sentence might contain other characters like digits or spaces, your solution should handle these too

 * Option 1, create a set of all the uniqie letters, consider upper and lower case as same, if set element count is 26 - returns true
 * O(N), O(26)
 * Option 2: Instead of a set- create an array of 26 elements, 0 corresponding to a and so on- count total updation, if 26 returns true

 */
package patterns.warmup;

import java.util.HashSet;
import java.util.Set;

public class Panagram {
    
    public boolean isPanagram(char[] sentence) {
        Set<Character> uniqueLetters =  new HashSet<>();
        for (Character c : sentence) {
            if (Character.isLetter(c)) {
                uniqueLetters.add(Character.toLowerCase(c));
                if (uniqueLetters.size() == 26) {
                    return true;
                }
            }
        }
        return false;
    }
}
