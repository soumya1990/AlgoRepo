
import java.util.Arrays;

import hashing.AnonyousLetter;
import hashing.LRUCache;
import hashing.LRUCacheCustom;
import hashing.PalindromePermutations;
import searching.FindKthElement;
import searching.FindMissingAndRepeated;
import searching.MinMaxFind;
import sorting.HoarePartitionSort;

public class App {
    public static void main(String[] args) throws Exception {
        testSearching();
        testSorting();
        testHashing();
    }

    private static void testSearching() {
        testMinMaxFind();
        testKLargest();
        testFindMissing();
    }

    private static void testHashing() {
        testPalindromePermutations();
        testAnonymousLetterFeasibility();
        testLRUCache();
    }

    private static void testLRUCache() {
        LRUCache<Integer, Integer> cache = new LRUCache<>(3);
        cache.get(1);
        cache.insert(2, 10);
        cache.insert(1, 9);
        cache.insert(3, 8);
        cache.insert(4, 7);
        cache.insert(2, 9);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        LRUCacheCustom<Integer, Integer> customCache = new LRUCacheCustom<>(3);
        // System.out.println(customCache.get(1));
        // customCache.put(1, 10);
        // System.out.println(customCache.get(1));
        // customCache.put(1, 11);
        // System.out.println(customCache.get(1));
        // customCache.remove(1);
        // System.out.println(customCache.get(1));

        customCache.put(1, 10);
        System.out.println(customCache.get(1));
        customCache.put(2, 20);
        System.out.println(customCache.get(2));
        customCache.put(3, 30);
        System.out.println(customCache.get(3));
        customCache.put(4, 40);
        System.out.println(customCache.get(4));
        customCache.put(5, 50);
        System.out.println(customCache.get(5));
        System.out.println("--------");
        System.out.println(customCache.get(1));
        System.out.println(customCache.get(2));
        System.out.println(customCache.get(3));
        System.out.println(customCache.get(4));
        System.out.println(customCache.get(5));
    }

    private static void testPalindromePermutations() {
        String s = "aacbdef";
        boolean res = new PalindromePermutations().isAnagramPalindrome(s);
        System.out.println("anagram of s" + s + " can be a palindrome ? " + res);
    }

    private static void testAnonymousLetterFeasibility() {
        String mag = "the nonkj kjfosdkf dhslkfsdk jnfdsljfkjs jldsjfklsdjf jnfjdslfksj kaljsjdfhsdkjwo";
        String letter = "dhslkklsdjfhkasdfsfsasfdfsfsdfsdfdsfewvrfrf"; // "dhslkklsdjfhk"
        boolean res = new AnonyousLetter().isAnonymousLetterFeasible(mag, letter);
        System.out.println("Is anonymous letter feasible = " + res);
        res = new AnonyousLetter().isAnonymousFeasible(letter, mag);
        System.out.println("Is anonymous letter feasible = " + res);
    }

    private static void testKLargest() {
        Integer[] a = { 4, 6, 1, 2, 3, 5 };
        Integer e = new FindKthElement<Integer>().findKthLargest(Arrays.asList(a), 1);
        System.out.println("element = " + e);
        a = new Integer[] { 3, 2, 4, 3, 3, 4, 1, 5, 1, 2, 3 };
        e = new FindKthElement<Integer>().findKthLargestNonDistinct(Arrays.asList(a), 8);
        System.out.println("element = " + e);
    }

    private static void testFindMissing() {
        int[] a = { 0, 1, 3, 4, 5 };
        int val = new FindMissingAndRepeated().findMissing(a);
        System.out.println("missing = " + val);
        assert val == 2;
        a = new int[] { 0, 2, 3, 1, 2 };
        val = new FindMissingAndRepeated().findRepeat(a);
        System.out.println("repeat = " + val);
        a = new int[] { 0, 1, 3, 2, 2 };
        int[] ans = new FindMissingAndRepeated().findMissingAndRepeat(a);
        System.out.println("missing = " + ans[0] + "repeat = " + ans[1]);
    }

    private static void testMinMaxFind() {

        Integer[] a = { 5, 6, 1, 2, 3, 5 };
        MinMaxFind<Integer>.MinMax res = new MinMaxFind<Integer>().findMinMax(Arrays.asList(a));
        System.out.println(res);
        a = new Integer[] { 6, 5, 4, 3, 2, 1 };
        res = new MinMaxFind<Integer>().findMinMax(Arrays.asList(a));
        System.out.println(res);

    }

    private static void testSorting() {
        Integer[] a = { 3, 2, 1, 2, 4, 5, 3, 3, 1, 3, 6 };
        new HoarePartitionSort<Integer>().sort(Arrays.asList(a));
        System.out.println(Arrays.toString(a));
    }
}
