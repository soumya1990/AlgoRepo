package patterns.slidingwindow;
/*
 * You are visiting a farm to collect fruits. The farm has a single row of fruit trees. You will be given two baskets, and your goal is to pick as many fruits as possible to be placed in the given baskets.

You will be given an array of characters where each character represents a fruit tree. The farm has following restrictions:

Each basket can have only one type of fruit. There is no limit to how many fruit a basket can hold.
You can start with any tree, but you can’t skip a tree once you have started.
You will pick exactly one fruit from every tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
Write a function to return the maximum number of fruits in both baskets.
 * 
 * 
 * Example ['a',a,'b', 'c', 'a'] return: 3
 */

import java.util.*;

public class FruitToBasket {

    public int getMaxFruits(char[] trees) {
        int start = 0;
        Map<Character, Integer> fruitCountMap = new HashMap<>();
        int maxCount = 0;
        for (int end = 0; end < trees.length; end++) {
            char type = trees[end];
            fruitCountMap.put(type, fruitCountMap.getOrDefault(type, 0) + 1);
            while (fruitCountMap.size() > 2) {
                Character first = trees[start];
                int fCount = fruitCountMap.get(first);
                fCount--;
                if (fCount == 0) {
                    fruitCountMap.remove(first);
                } else {
                    fruitCountMap.put(first, fCount);
                }
                first++;
            }
            maxCount = Math.max(maxCount, end - start + 1);
        }

        return maxCount;

    }

}
