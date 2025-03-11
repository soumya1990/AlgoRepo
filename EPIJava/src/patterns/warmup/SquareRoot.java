package patterns.warmup;

/*
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 * 
 * Option 1: go from 1..x - find the biggest square  < x - O(x/2)
 * Option 2: do a binary search 
 * Example: x = 15
 * (1,15) -> (1-6) ->(4-6) -> 4->4 (4,3)
 */
public class SquareRoot {

    public int binaryRootSearch(int x) {
        int l = 1;
        int h = x;// 2
        long num;
        int m;
        while (l <= h) { // 2,2; (2,1)
            m = l + (h - l) / 2; // 1
            num = (long) m * m;
            if (num == x)
                return m;
            else if (num < x) {
                l = m + 1;// l = 2
            } else {
                h = m - 1; // h = 1
            }
        }
        return h;
    }
}
