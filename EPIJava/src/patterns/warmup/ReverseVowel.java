/*
 * Given a string s, reverse only all the vowels in the string and return it.
 The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * Option 1:
 *          a,e,i,o,u - i from start, j from end - exchange when both are vowel, do until all the elements are covered
 * TC = O(N = length of string) 
 * SC =O(N) as string is immutable
 */
package patterns.warmup;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowel {

    Set<Character> vowels;

    public ReverseVowel() {
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public String reverseVowel(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] sArr = s.toCharArray();
        while (j > i) {
            if (isAVowel(sArr[i])
                    && isAVowel(sArr[j])) {
                exchange(sArr, i++, j--);
            } else if (!isAVowel(sArr[i])) {
                i++;
            } else if (!isAVowel(sArr[j])) {
                j--;
            }
        }
        return new String(sArr);
    }

    private boolean isAVowel(char c) {
        return vowels.contains(Character.toLowerCase(c));
    }

    private void exchange(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
