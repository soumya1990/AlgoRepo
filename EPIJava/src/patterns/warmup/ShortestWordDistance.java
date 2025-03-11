package patterns.warmup;

/**
 * Given an array of strings words and two different strings that already exist
 * in the array word1 and word2,
 * return the shortest distance between these two words in the list.
 * Option 1: Update the distance in a greedy approach
 * Example: arr = {1,a,b,2,a,c,2,w,1,1,a,s,f,2} w1 = 1, w2 = 2
 * Algo:
 * - track latest w1 and w2 indices
 * - update the distance greedily
 * 
 */
public class ShortestWordDistance {

    public int getShortestDistance(String[] sentence, String w1, String w2) {
        int w1Idx = -1;
        int w2Idx = -1;
        int dist = sentence.length;
        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i].equals(w1)) {
                w1Idx = i;
            }
            if (sentence[i].equals(w2)) {
                w2Idx = i;
            }
            if (w1Idx != -1 && w2Idx != -1) {
                dist = Math.min(dist, Math.abs(w1Idx - w2Idx));
            }
        }
        return dist;
    }

}
