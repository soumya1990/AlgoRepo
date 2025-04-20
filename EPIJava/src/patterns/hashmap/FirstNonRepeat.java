package patterns.hashmap;

import java.util.*;

/*
 * Given a string, 
 * identify the position of the first character that appears only once in the string. 
 * If no such character exists, return -1.
 * 
 */
public class FirstNonRepeat {

    public int firstNonRepeat(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character k = s.charAt(i);
            countMap.put(k, countMap.getOrDefault(k, 0) + 1);
        }
        int fIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                fIdx = i;
                break;
            }
        }
        return fIdx;
    }
    /*
     * T1: aac
     * set //c,a,a
     * ans: a
     * 
     */

}
