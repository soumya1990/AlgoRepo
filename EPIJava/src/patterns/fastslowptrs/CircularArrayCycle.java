/*
 * This problem involves finding a cycle in the array and, as we know, the Fast & Slow pointer method is an efficient way to do that. We can start from each index of the array to find the cycle. If a number does not have a cycle we will move forward to the next element. There are a couple of additional things we need to take care of:

As mentioned in the problem, the cycle should have more than one element.
 This means that when we move a pointer forward, 
 if the pointer points to the same element after the move, we have a one-element cycle.
  Therefore, we can finish our cycle search for the current element.
The other requirement mentioned in the problem is that the cycle should not contain both forward and backward movements.
 We will handle this by remembering the direction of each element while searching for the cycle. 
 If the number is positive, the direction will be forward and if the number is negative, the direction will be backward.
  So whenever we move a pointer forward, 
if there is a change in the direction, we will finish our cycle search right there for the current element.
 * 
 * 
 */

package patterns.fastslowptrs;

/*
 * We are given an array containing positive and negative numbers.
 *  Suppose the array contains a number ‘M’ at a particular index. 
 * Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices. 
 * You should assume that the array is circular which means two things:
 * 
*If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
*If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
*Write a method to determine if the array has a cycle. 
*The cycle should have more than one element and should follow one direction which means the cycle should 
not contain both forward and backward movements.
 * 
 * 
 * Example:
 * {-2, 1, -2, 1, 3}
 * 
 */
public class CircularArrayCycle {

    public boolean hasCycle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int slowIdx = i;
            int fastIdx = i;
            boolean isForward = arr[i] >= 0;

            do {
                slowIdx = getNextIdx(arr, slowIdx, isForward);
                fastIdx = getNextIdx(arr, fastIdx, isForward);
                if (fastIdx != -1) {
                    fastIdx = getNextIdx(arr, fastIdx, isForward);
                }
            } while (slowIdx != -1 && fastIdx != -1 && slowIdx != fastIdx);
            if (slowIdx != -1 && slowIdx == fastIdx) {
                return true;
            }
        }
        return false;
    }

    private int getNextIdx(int[] arr, int currIdx, boolean isForward) {
        boolean direction = arr[currIdx] >= 0;
        if (direction != isForward) {
            return -1;
        }
        int nextIdx = (currIdx + arr[currIdx]) % arr.length;
        if (nextIdx < 0) {
            nextIdx = nextIdx + arr.length;
        }
        if (nextIdx == currIdx) {
            return -1;
        }
        return nextIdx;

    }

}
