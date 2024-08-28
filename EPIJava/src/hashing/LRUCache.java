package hashing;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

/**
 * This is an O(n) implementation since finding an element in list taked O(n)
 * time.
 */

public class LRUCache<K, V> {
    private List<K> mCacheList = null;
    private Map<K, V> mCacheMap = null;
    private int capacity = 0;

    public LRUCache(int capacity) {
        mCacheList = new LinkedList<>();
        mCacheMap = new HashMap<>();
        this.capacity = capacity;
    }

    public void insert(K key, V value) {
        if (mCacheMap.containsKey(key)) {
            // if key exists don't update the key - just update it's recency of use.
            mCacheList.remove(key);
            mCacheList.add(0, key);
        } else {
            if (mCacheList.size() == capacity) {
                K eldestKey = mCacheList.get(mCacheList.size() - 1);
                mCacheList.remove(eldestKey);
                // O(n)
                mCacheMap.remove(eldestKey);
            }
            mCacheList.add(0, key);
            mCacheMap.put(key, value);
        }

    }

    public void remove(K key) {
        // O(n)
        mCacheList.remove(key);
        mCacheMap.remove(key);
    }

    public V get(K key) {
        V val = mCacheMap.get(key);
        if (mCacheMap.containsKey(key)) {

            // O(n)
            mCacheList.remove(key);
            mCacheList.add(0, key);
        }
        return val;
    }
}
