# **TreeMap in Java**
`TreeMap` is a part of the `java.util` package and implements the `NavigableMap` interface, which extends `SortedMap`. It stores **key-value pairs** in **sorted order of keys** (natural order by default) and is backed by a **Red-Black Tree**, ensuring logarithmic (`O(log n)`) time complexity for operations.

---

## **Main Methods of TreeMap**

### **1. Adding and Removing Entries**
- `V put(K key, V value)`: Inserts a key-value pair into the map. If the key already exists, the value is updated.
- `void putAll(Map<? extends K, ? extends V> m)`: Copies all mappings from the specified map to this map.
- `V remove(Object key)`: Removes the mapping for the specified key.
- `void clear()`: Removes all mappings from the map.

### **2. Accessing Elements**
- `V get(Object key)`: Returns the value associated with the specified key.
- `boolean containsKey(Object key)`: Checks if the map contains the specified key.
- `boolean containsValue(Object value)`: Checks if the map contains the specified value.
- `int size()`: Returns the number of key-value mappings.
- `boolean isEmpty()`: Checks if the map is empty.

### **3. NavigableMap Methods (Descending and Floor/Ceiling Operations)**
- `K firstKey()`: Returns the first (lowest) key.
- `K lastKey()`: Returns the last (highest) key.
- `K lowerKey(K key)`: Returns the greatest key **less than** the specified key, or `null` if none exists.
- `K floorKey(K key)`: Returns the greatest key **less than or equal to** the specified key, or `null` if none exists.
- `K ceilingKey(K key)`: Returns the smallest key **greater than or equal to** the specified key, or `null` if none exists.
- `K higherKey(K key)`: Returns the smallest key **greater than** the specified key, or `null` if none exists.
- `NavigableMap<K,V> descendingMap()`: Returns a **reverse-order** view of the mappings.

### **4. SubMap Methods**
- `SortedMap<K,V> headMap(K toKey)`: Returns a view of the portion of the map whose keys are **less than** `toKey`.
- `SortedMap<K,V> tailMap(K fromKey)`: Returns a view of the portion of the map whose keys are **greater than or equal to** `fromKey`.
- `SortedMap<K,V> subMap(K fromKey, K toKey)`: Returns a view of the portion of the map ranging from `fromKey` (inclusive) to `toKey` (exclusive).

### **5. Iteration Methods**
- `Set<K> keySet()`: Returns a `Set` view of the keys.
- `Collection<V> values()`: Returns a `Collection` view of the values.
- `Set<Map.Entry<K, V>> entrySet()`: Returns a `Set` view of the key-value pairs.

### **6. Cloning and Comparators**
- `Object clone()`: Returns a **shallow copy** of the `TreeMap` instance.
- `Comparator<? super K> comparator()`: Returns the **comparator** used for ordering, or `null` if natural ordering is used.

---

## **Example Usage**
```java
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> students = new TreeMap<>();

        // Adding entries
        students.put(102, "Alice");
        students.put(101, "Bob");
        students.put(103, "Charlie");

        System.out.println("TreeMap: " + students); // Output: {101=Bob, 102=Alice, 103=Charlie}

        // Accessing elements
        System.out.println("First Key: " + students.firstKey()); // 101
        System.out.println("Last Key: " + students.lastKey()); // 103

        // NavigableMap methods
        System.out.println("Lower Key than 103: " + students.lowerKey(103)); // 102
        System.out.println("Ceiling Key of 102: " + students.ceilingKey(102)); // 102

        // SubMap example
        System.out.println("HeadMap(103): " + students.headMap(103)); // {101=Bob, 102=Alice}
        System.out.println("TailMap(102): " + students.tailMap(102)); // {102=Alice, 103=Charlie}
    }
}
```

---

## **Key Features of `TreeMap`**
✔ **Sorted Order**: Keys are stored in **ascending** order.  
✔ **No Duplicate Keys**: `TreeMap` does **not allow duplicate keys** (but values can be duplicate).  
✔ **Balanced Tree Implementation**: Uses a **Red-Black Tree**, ensuring efficient operations (`O(log n)`).  
✔ **Thread Safety**: Not synchronized; use `Collections.synchronizedMap(new TreeMap<>())` for thread safety.  

---

### **Comparison: TreeMap vs. HashMap vs. LinkedHashMap**
| Feature         | TreeMap | HashMap | LinkedHashMap |
|----------------|---------|---------|--------------|
| **Ordering**   | Sorted by keys | No ordering | Insertion order |
| **Time Complexity** | `O(log n)` | `O(1)` (Average), `O(n)` (Worst) | `O(1)` |
| **Allows Null Keys** | ❌ No | ✅ Yes (One `null` key) | ✅ Yes (One `null` key) |
| **Allows Null Values** | ✅ Yes | ✅ Yes | ✅ Yes |
| **Best Use Case** | When elements need to be **sorted by keys** | **Fastest** for general-purpose key-value storage | When **insertion order must be maintained** |

---

## **Conclusion**
- `TreeMap` is an **efficient and ordered** key-value storage structure.
- It provides several **navigation methods** (`lowerKey()`, `higherKey()`, `ceilingKey()`, `floorKey()`).
- Ideal for applications where **sorted keys** and **fast lookups** are needed.


