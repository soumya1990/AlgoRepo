/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * Option 1: traverse i from front and j from back -
 *       - skip ineligibe chars
 *         - for elgibe compare case insenistive equal - if not - it is not palindrome
 *          - if equal continue
 *      - it is a palindrome if we complete the loop
 * TC = O(N)
 * SC = O(1)
 */
package patterns.warmup;

public class ValidPalindrome {
    public boolean isValidPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (j > i) {
            if (Character.isLetterOrDigit(s.charAt(i))
                    && Character.isLetterOrDigit(s.charAt(j))) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            } else if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else {
                j--;
            }

        }
        return true;
    }
}
