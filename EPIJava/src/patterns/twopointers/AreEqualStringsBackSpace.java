package patterns.twopointers;
/*
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 * example: str1: "xy#z" str2 = "xzz#x#" - equals = true
 * xy#zabc####
 * Algo  : 
 * Option 1: 
 *      Create a stack of characters if "#" pop, else push - compare both stacks
 *       TC: O(N) SC: O(N)
 * 
 * Option 2: 
 * start from the end -
 * Get last element after applying back spaces from s1 and s2
 * Compare the char - if not equal return false
 * else continue
 * End - both s1 and s2 have no elements left
 */

public class AreEqualStringsBackSpace {

    public boolean areEquals(String s1, String s2) { // xy,xy
        int i = s1.length() - 1; // 1
        int j = s2.length() - 1;// 1
        while (i >= 0 || j >= 0) {
            i = applyBackSpaces(s1, i); // 1,0
            j = applyBackSpaces(s2, j); // 1,0
            if (i < 0 && j < 0) {
                return true;
            } else if (i < 0 || j < 0) {
                return false;
            }
            if (s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            i--;// 0,-1
            j--;// 0,-1
        }

        return true;
    }

    // x## y#
    private int applyBackSpaces(String s, int k) {// cbbbb####, 8
        // k<=s.length()
        int bCount = 0;
        while (k >= 0) {
            if (s.charAt(k) == '#') {
                bCount++;
            } else if (bCount > 0) {
                bCount--;
            } else {
                break;
            }
            k--;
        }
        return k;
    }
    /*
     * Test Case:
     * xy xy
     * 
     */
}
