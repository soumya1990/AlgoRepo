package patterns.hashmap;

import java.util.*;

/*
 * Given two strings, one representing a ransom note and the other representing the available letters from a magazine, 
 * determine if it's possible to construct the ransom note using only the letters from the magazine. 
 * Each letter from the magazine can be used only once.
 * Ransom Note = "hello", Magazine = "hellworld"
 */
public class RansomNote {

    public boolean isRansomNotePossible(String n, String m) { //h,1;e,1;l,2;o,1
        Map<Character, Integer> countMapNote = new HashMap<>();
        for (Character c : n.toCharArray()) {
            countMapNote.put(c, countMapNote.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < m.length(); i++) {
            if (countMapNote.containsKey(m.charAt(i))) {
                if (countMapNote.get(m.charAt(i)) == 1) {
                    countMapNote.remove(m.charAt(i));
                } else {
                    countMapNote.put(m.charAt(i), countMapNote.get(m.charAt(i)) - 1);
                }
            }
            if (countMapNote.isEmpty()) {
                return true;
            }
        }
        return false;

    }

}
