package patterns.slidingwindow;

import java.util.*;

/*
 * Given a string and a list of words, find all the starting indices of substrings in the given string that are a concatenation of all the given words exactly once 
 * without any overlapping of words. It is given that all words are of the same length.

Example 1:

Input: String="catfoxcat", Words=["cat", "fox"]  
Output: [0, 3]  
Explanation: The two substring containing both the words are "catfox" & "foxcat".
Example: catcatcatfox
 * 
 */
public class Concatpattern {
    public List<Integer> getConcatPatterns(String s, List<String> words/* Not empty/null */) {// "catfoxcat"
        Map<String, Integer> wordMap = new HashMap<>();
        List<Integer> resIndices = new LinkedList<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        int pLength = words.get(0).length();// 3
        for (int start = 0; start + (pLength*words.size()) - 1 < s.length(); start++) { 
            Map<String,Integer> matched = new HashMap<>();
            for (int j = 0; j < words.size(); j++) {//0;1
                int startIndex = start + j * pLength; // 0;3
                String currentWord = s.substring(startIndex, startIndex + pLength);\
                if (!wordMap.containsKey(currentWord)) {
                    break;
                } 
                matched.put(currentWord, wordMap.getOrDefault(currentWord, 0) + 1);
               
                if (matched.get(currentWord) > wordMap.get(currentWord)) {
                  // word is already satisfied, this is extra
                    break;
                }
                
                if (j+1 == words.size()) { // if we have reached the end for j - we have found the word
                    resIndices.add(start);//[0]
                }
            }
        }
        return resIndices;

    }

}
