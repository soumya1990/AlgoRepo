package searching;

public class FindMissingAndRepeated {

    /*
     * If an array contains n-1 integers, each between 0 and n-1, inclusive,
     * all numbers are unique then 1 element will be missing.
     * find missing number
     */
    public int findMissing(int[] arr) {
        long sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        long total = n * (n + 1) / 2;
        return (int) (total - sum);
    }

    /*
     * If array contains n+1 integers, each between 0 to n-1, inclusive,
     * all numbers are unique except one, find the repeating integer.
     */
    // 0,1,2,3,2
    public int findRepeat(int[] arr) {
        int n = arr.length;// 5
        int repeat = 0;
        for (int i = 0; i < n; i++) {
            repeat ^= arr[i];// 0^1^2^3^2^0^1^2^3 = 2
            if (i != n - 1) {
                repeat ^= i;
            }
        }
        return repeat;
    }

    /**
     * If array contains n integers, each between 0 and n-1, inclusive,
     * all numbers are unique except one is repeated and one is missing.
     * Find the missing and repeat element.
     */
    // { 0, 1, 3, 2, 2 }
    // 0,1,2,3,4

    public int[] findMissingAndRepeat(int[] arr) {
        int missing = 0;
        int repeat = 0;
        int missingXORrepeat = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            missingXORrepeat ^= arr[i];
            missingXORrepeat ^= i;
        }
        // find any set bit i of missingXORRepeat
        // segrgate elements and possible elements based on the set bit i
        // do xor of missingXORrepeat with one set to get missing or repeat.
        // find the other one
        int x = missingXORrepeat; // 2 ^ 4 = 10 ^ 100 = 110 = 6
        int mask = 1;
        while (x > 0) {
            if ((x & 1) == 1) {
                break;
            }
            x = x >>> 1; // 3(11)
            mask = mask << 1; // 2(10)
        }
        // System.out.println("mask = " + mask);
        // { 0, 1, 3, 2, 2 }
        // 0,1,2,3,4
        int oneAns = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & mask) == mask) { // 11 & 10
                oneAns ^= arr[i]; // 0 ^ 3 ^ 2 ^ 2
                // System.out.println("^" + arr[i]);
            }
            if ((i & mask) == mask) {
                oneAns ^= i; // ^ 2 ^ 3
                // System.out.println("^" + i);
            }
        }
        System.out.println("OneAns = " + oneAns);

        boolean isRepeat = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == oneAns) {
                isRepeat = true;
                break;
            }
        }
        if (isRepeat) {
            repeat = oneAns;
            missing = missingXORrepeat ^ repeat;
        } else {
            missing = oneAns;
            repeat = missingXORrepeat ^ missing;
        }
        return new int[] { missing, repeat };
    }
}