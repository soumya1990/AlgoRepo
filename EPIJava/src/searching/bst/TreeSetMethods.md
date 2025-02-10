# **TreeSet in Java**
`TreeSet` is a part of the `java.util` package and implements the `NavigableSet` interface, which extends `SortedSet`. It stores **unique elements** in **sorted order** (ascending by default) and is backed by a **Red-Black Tree**, ensuring logarithmic (`O(log n)`) time complexity for operations.

---

## **Main Methods of TreeSet**

### **1. Adding and Removing Elements**
- `boolean add(E e)`: Adds the specified element to the set if it is not already present.
- `boolean remove(Object o)`: Removes the specified element from the set.
- `void clear()`: Removes all elements from the set.

### **2. Accessing Elements**
- `E first()`: Returns the first (lowest) element in the set.
- `E last()`: Returns the last (highest) element in the set.
- `boolean contains(Object o)`: Checks if the set contains the specified element.
- `int size()`: Returns the number of elements in the set.
- `boolean isEmpty()`: Checks if the set is empty.

### **3. NavigableSet Methods (Descending and Floor/Ceiling Operations)**
- `E lower(E e)`: Returns the greatest element **less than** the specified element, or `null` if none exists.
- `E floor(E e)`: Returns the greatest element **less than or equal to** the specified element, or `null` if none exists.
- `E ceiling(E e)`: Returns the smallest element **greater than or equal to** the specified element, or `null` if none exists.
- `E higher(E e)`: Returns the smallest element **greater than** the specified element, or `null` if none exists.
- `NavigableSet<E> descendingSet()`: Returns a **reverse-order** view of the elements.

### **4. Subset Methods**
- `SortedSet<E> headSet(E toElement)`: Returns a view of the portion of the set whose elements are **less than** `toElement`.
- `SortedSet<E> tailSet(E fromElement)`: Returns a view of the portion of the set whose elements are **greater than or equal to** `fromElement`.
- `SortedSet<E> subSet(E fromElement, E toElement)`: Returns a view of the portion of the set ranging from `fromElement` (inclusive) to `toElement` (exclusive).

### **5. Iteration Methods**
- `Iterator<E> iterator()`: Returns an iterator over the elements in **ascending order**.
- `Iterator<E> descendingIterator()`: Returns an iterator over the elements in **descending order**.

### **6. Cloning and Comparators**
- `Object clone()`: Returns a **shallow copy** of the `TreeSet` instance.
- `Comparator<? super E> comparator()`: Returns the **comparator** used for ordering, or `null` if natural ordering is used.

---

## **Example Usage**
```java
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();

        // Adding elements
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(15);

        System.out.println("TreeSet: " + numbers); // Output: [5, 10, 15, 20]

        // Accessing elements
        System.out.println("First: " + numbers.first()); // 5
        System.out.println("Last: " + numbers.last()); // 20

        // NavigableSet methods
        System.out.println("Lower than 15: " + numbers.lower(15)); // 10
        System.out.println("Ceiling of 12: " + numbers.ceiling(12)); // 15

        // SubSet example
        System.out.println("HeadSet(15): " + numbers.headSet(15)); // [5, 10]
        System.out.println("TailSet(10): " + numbers.tailSet(10)); // [10, 15, 20]
    }
}
```

---

## **Key Features of `TreeSet`**
✔ **Sorted Order**: Elements are stored in **ascending** order.  
✔ **No Duplicates**: `TreeSet` does **not allow duplicate elements**.  
✔ **Balanced Tree Implementation**: Uses a **Red-Black Tree**, ensuring efficient operations (`O(log n)`).  
✔ **Thread Safety**: Not synchronized; use `Collections.synchronizedSet(new TreeSet<>())` for thread safety.  

---

### **Comparison: TreeSet vs. HashSet vs. LinkedHashSet**
| Feature         | TreeSet | HashSet | LinkedHashSet |
|----------------|---------|---------|--------------|
| **Ordering**   | Sorted order | No ordering | Insertion order |
| **Time Complexity** | `O(log n)` | `O(1)` (Average), `O(n)` (Worst) | `O(1)` |
| **Allows Null** | ❌ No | ✅ Yes (Only one `null` element) | ✅ Yes (Only one `null` element) |
| **Best Use Case** | When elements need to be **sorted** | **Fastest** for general-purpose set operations | When **insertion order must be maintained** |

---

## **Conclusion**
- `TreeSet` is an **efficient and ordered** collection that does not allow duplicates.
- It provides several **navigation methods** (`lower()`, `higher()`, `ceiling()`, `floor()`).
- Ideal for applications where **sorted data** and **fast access** are needed.


