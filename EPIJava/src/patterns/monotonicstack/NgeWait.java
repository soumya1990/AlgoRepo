package patterns.monotonicstack;
import java.util.*;

/*Given an array of integers temperatures representing daily temperatures, your task is to calculate how many days you have to wait until a warmer temperature.
 If there is no future day for which this is possible, put 0 instead.
 * 
 * Example: 
 * [20,13,21,25,10,19,15]
 */
public class NgeWait {
    public int[] ngeWaitDays(int[] temps) {
        Map<Integer, Integer> ngeIdxRecord = new HashMap<>();//<1,1>,<0,2>,<4,1> //nit: can use the res directly
        LinkedList<Integer> stackIdx = new LinkedList<>(); // 3,5,6
        for (int i = 0; i < temps.length; i++) {
            while (!stackIdx.isEmpty() && temps[stackIdx.peek()] < temps[i]) {
                int idx = stackIdx.pop();
                ngeIdxRecord.put(idx, i - idx);
            }
            stackIdx.push(i);
        }
        int[] ans = new int[temps.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ngeIdxRecord.getOrDefault(i, 0);
        }
        return ans;
    }

}
