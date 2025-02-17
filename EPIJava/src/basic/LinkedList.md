# **LinkedList in Java**
`LinkedList` is a part of the `java.util` package and implements both the `List` and `Deque` interfaces. It provides a **doubly-linked list** implementation, allowing efficient insertions and deletions.

---

## **Common Methods of LinkedList**

### **1. Adding Elements**
- `boolean add(E e)`: Appends the specified element to the end of the list.
- `void add(int index, E element)`: Inserts the specified element at the specified position.
- `boolean offer(E e)`: Inserts the specified element at the end of the list.
- `void addFirst(E e)`: Inserts the specified element at the beginning of the list.
- `void addLast(E e)`: Inserts the specified element at the end of the list.

### **2. Removing Elements**
- `E remove()`: Retrieves and removes the head (first element).
- `E remove(int index)`: Removes the element at the specified position.
- `E removeFirst()`: Removes the first element.
- `E removeLast()`: Removes the last element.
- `boolean remove(Object o)`: Removes the first occurrence of the specified element.
- `E poll()`: Retrieves and removes the head, returning `null` if the list is empty.

### **3. Accessing Elements**
- `E get(int index)`: Returns the element at the specified position.
- `E getFirst()`: Returns the first element.
- `E getLast()`: Returns the last element.
- `E peek()`: Retrieves the head without removing it, returning `null` if empty.
- `E peekFirst()`: Retrieves the first element without removing it.
- `E peekLast()`: Retrieves the last element without removing it.

### **4. Searching and Checking**
- `boolean contains(Object o)`: Checks if the list contains the specified element.
- `int indexOf(Object o)`: Returns the index of the first occurrence of the specified element.
- `int lastIndexOf(Object o)`: Returns the index of the last occurrence of the specified element.

### **5. Updating Elements**
- `E set(int index, E element)`: Replaces the element at the specified position.

### **6. Iteration Methods**
- `Iterator<E> iterator()`: Returns an iterator over the elements.
- `ListIterator<E> listIterator()`: Returns a list iterator starting at the beginning.
- `ListIterator<E> listIterator(int index)`: Returns a list iterator starting at the specified index.
- `DescendingIterator<E> descendingIterator()`: Returns an iterator that iterates in reverse order.

### **7. Size and Clearing**
- `int size()`: Returns the number of elements in the list.
- `boolean isEmpty()`: Checks if the list is empty.
- `void clear()`: Removes all elements from the list.

---

## **Example Usage**
```java
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();

        // Adding elements
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println("LinkedList: " + names);

        // Accessing elements
        System.out.println("First Element: " + names.getFirst()); // Alice
        System.out.println("Last Element: " + names.getLast());   // Charlie

        // Removing elements
        names.removeFirst();
        System.out.println("After removeFirst(): " + names);
    }
}
```

---

## **Key Features of `LinkedList`**
✔ **Efficient Insertions/Deletions**: Faster than `ArrayList` for adding/removing elements in the middle.  
✔ **Doubly-Linked List**: Elements are linked in both directions, making bidirectional traversal possible.  
✔ **Implements Deque**: Supports queue-related operations (`offer()`, `poll()`, `peek()`).  
✔ **Not Synchronized**: Use `Collections.synchronizedList(new LinkedList<>())` for thread safety.

---

### **Comparison: LinkedList vs. ArrayList**
| Feature         | LinkedList | ArrayList |
|----------------|------------|-----------|
| **Implementation** | Doubly-Linked List | Dynamic Array |
| **Insertion/Deletion** | `O(1)` (at start/end), `O(n)` (at middle) | `O(n)` |
| **Random Access** | `O(n)` (Slower) | `O(1)` (Faster) |
| **Memory Usage** | Higher (Extra pointers) | Lower |
| **Best Use Case** | When frequent insertions/removals are needed | When fast random access is required |

---

## **Conclusion**
- `LinkedList` is a **versatile list implementation** useful for **fast insertions and deletions**.
- It provides **queue and stack** functionalities.
- Ideal for scenarios where **modifications are frequent**.


