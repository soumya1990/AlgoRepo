package hashing;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheCustom<K, V> {

    private int capacity = 0;
    private int size = 0;
    private Map<K, Node> cachedMap;
    private Node head = null;
    private Node tail = null;

    class Node {
        K key;
        V val;
        Node prev = null;
        Node next = null;

        public Node(K k, V v) {
            key = k;
            val = v;
        }
    }

    private void addFirst(Node n) {
        Node tmp = head.next;
        head.next = n;
        n.prev = head;
        n.next = tmp;
        if (tmp != null) {
            tmp.prev = n;
        } else {
            tail = n;
        }
        size++;
        // System.out.println("Size = " + size);
        // printListReverse();
    }

    private void printList() {
        System.out.println("List content");
        System.out.println("--------");
        Node c = head;
        while (c != null) {
            System.out.println(c.key);
            c = c.next;
        }
        System.out.println("--------");

    }

    private void printListReverse() {
        System.out.println("List content reverse");
        System.out.println("--------");
        Node c = tail;
        while (c != head) {
            System.out.println(c.key);
            c = c.prev;
        }
        System.out.println("--------");

    }

    private void removeLast() {
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    private void remove(Node n) {
        if (n == tail) {
            removeLast();
        } else {
            n.next.prev = n.prev;
            n.prev.next = n.next;
            size--;

        }
    }

    public LRUCacheCustom(int capacity) {
        this.capacity = capacity;
        head = new Node(null, null);
        tail = head;
        cachedMap = new HashMap<>();
    }

    public void put(K key, V value) {
        if (!cachedMap.containsKey(key)) {
            if (size == capacity) {
                cachedMap.remove(tail.key);
                removeLast();
            }
            Node n = new Node(key, value);
            cachedMap.put(key, n);
            addFirst(n);
        } else {
            // only update recency and not value [ISBN problem requirement]
            Node v = cachedMap.get(key);
            remove(v);
            addFirst(v);
        }
    }

    public V get(K key) {
        if (cachedMap.containsKey(key)) {
            Node v = cachedMap.get(key);
            remove(v);
            addFirst(v);
            return v.val;
        }
        return null;
    }

    public void remove(K key) {
        Node v = cachedMap.get(key);
        cachedMap.remove(key);
        remove(v);
    }

}
