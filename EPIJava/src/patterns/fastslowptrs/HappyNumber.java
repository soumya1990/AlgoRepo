package patterns.fastslowptrs;

/*
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, 
 * leads us to the number 1. 
 * All other (not-happy) numbers will never reach 1. Instead, they will be stuck in a cycle of numbers that does not include 1.
Given a positive number n, return true if it is a happy number otherwise return false
 * 
 * Example: 25 = 4+25 = 29 -> 4 + 81 -> 85 -> 64+25 ->89 -> 64+81 -> 145 -> 1+16+25 = 42 ->20 ->4
 * 99 -> 81+81 = 162 -> 
 * 
 * Option 1: store the elements in a set and check for cycle.
 * 
 */
public class HappyNumber {

    public boolean isHappyNumber(int num) {

        int slow = num;
        int fast = num;
        while (slow != 1 && fast != 1) {
            slow = getSquaredSum(slow);
            fast = getSquaredSum(getSquaredSum(fast));
            if (slow == fast) {
                if (slow == 1) return true;
                return false;
            }
        }
        return true;
    }

    private int getSquaredSum(int n) {
        int sum = 0;
        do {
            int d = n % 10;
            sum += d * d;
            n = n / 10;
        } while (n > 0);
        return sum;
    }

    /*
     * TestCase: 
     * 1. n =19
     *      19,89,145,42,20,4,7,13,10,1
     * 
     */

}
