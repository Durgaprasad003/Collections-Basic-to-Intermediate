What is Collection Framework?

Java Collection Framework is a set of classes and interfaces used to store and manipulate group of objects dynamically.
Instead of:
int[] arr = new int[5];
Use:
ArrayList<Integer> list = new ArrayList<>();

Because:
Dynamic size
Built-in methods
Easy insert/delete
Sorting
Searching
Thread-safe options available


Why Arrays Are Not Enough
Problems of Arrays
1 Fixed Size
int[] arr = new int[5];
Cannot grow automatically.
2 No Built-in Methods
Need manual sorting/searching.
3 Can store primitives only directly.
4 Wasted Memory
If size 100, use 2.


Why Collections Better
ArrayList<String> names = new ArrayList<>();
names.add("Ram");
names.add("John");
names.add("David");

Can grow automatically.


COLLECTION HIERARCHY
Iterable
   |
Collection
 /   |    \
List Set Queue

Map (separate)



__________________________________Iterable Interface_____________________

Used for foreach loop.
for(String s : list)

Methods:
iterator()
forEach()
spliterator()



Collection Interface

Root interface of List, Set, Queue.

Methods:
add()
remove()
size()
isEmpty()
contains()
clear()
iterator()
toArray()

| Method               | Return Type   | Explanation                                                              |
| -------------------- | ------------- | ------------------------------------------------------------------------ |
| `add(E e)`           | `boolean`     | Adds an element to the collection. Returns `true` if added successfully. |
| `remove(Object o)`   | `boolean`     | Removes the specified element. Returns `true` if removed.                |
| `size()`             | `int`         | Returns the number of elements in the collection.                        |
| `isEmpty()`          | `boolean`     | Returns `true` if the collection has no elements.                        |
| `contains(Object o)` | `boolean`     | Returns `true` if the collection contains the element.                   |
| `clear()`            | `void`        | Removes all elements from the collection.                                |
| `iterator()`         | `Iterator<E>` | Returns an iterator to traverse elements one by one.                     |
| `toArray()`          | `Object[]`    | Converts the collection into an array of objects.                        |



_______________________________________________LIST Interface_________________________________________
A List is a collection that:

Stores elements in insertion order
Allows duplicate values
Allows accessing elements by index
Can grow dynamically

Common Classes That Implement List
ArrayList
LinkedList
Vector
Stack


Common Methods
add()
remove()
get()
set()
contains()
size()
isEmpty()

| Method             | Return Type | Use                              |
| ------------------ | ----------- | -------------------------------- |
| `get(index)`       | `E`         | returns element at index         |
| `set(index,value)` | `E`         | replaces and returns old element |



**************************get and set methods are belong to list interface not collection interface so they dont work in collection         Collection<String> lis=new ArrayList<>();

************************* in list interface for removing we can insert index or object name  to remove the element




Important List Methods
add(E e)
add(int index,E e)
get(int index)
set(int index,E e)
remove(int index)
remove(Object o)
indexOf()
lastIndexOf()
subList()
listIterator()


******************************************************
So changes in the sublist usually reflect in the main list, and some changes in the main list affect the sublist too.









import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Mango");
        list2.add("Orange");

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("Grapes");
        list3.add("Pineapple");

        // Insert all elements of list2 into list1 at index 1
        list1.addAll(1, list2);

        // Add all elements of list3 at end of list1
        list1.addAll(list3);

        System.out.println(list1);
    }
}
Output:
[Apple, Mango, Orange, Banana, Grapes, Pineapple]



 numbers.add(5);***********************************
        numbers.add(9);
        numbers.add(3);
        numbers.add(9);
        numbers.add(7);

        System.out.println("Before Remove: " + numbers);

        numbers.remove(numbers.indexOf(9));

        System.out.println("After Remove: " + numbers);
    
Output:
Before Remove: [5, 9, 3, 9, 7]
After Remove: [5, 3, 9, 7]






In Java ArrayList, remove() is an important interview topic because it is overloaded (same method name, different parameters).

Two remove() methods
remove(int index)
remove(Object obj)
Key Rule for Integer ArrayList

If you pass a number directly:

list.remove(2);

Java usually treats 2 as an index, not a value.

So it removes the element at index 2.

Example
ArrayList<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);
list.add(40);

list.remove(2);

System.out.println(list);
Output
[10, 20, 40]

Because index 2 = value 30.



Remove by value (important)

To remove number 20 as an object/value:

list.remove(Integer.valueOf(20));****************************************

Integer.valueOf(2) means:

Convert the primitive int value 2 into an Java Integer Integer object.

Simple Meaning
int x = 2;                 // primitive
Integer y = Integer.valueOf(2);   // object
2 → primitive data type (int)
Integer.valueOf(2) → wrapper object (Integer)



Quick Answer
Use enhanced for-loop → best for simple reading/traversing
Use Iterator → best when removing elements during traversal
Use index for-loop → best mainly for Java ArrayList when index access is needed
Avoid index loop for LinkedList → slower


No, an Iterator is mainly used to traverse and remove elements, not add elements.
With Iterator
You can :
Read elements using next()
Check elements using hasNext()
Remove current element using remove()



Yes — with ListIterator, you can add elements.

ListIterator supports the add(E e) method, which inserts an element at the iterator’s current position while iterating.

Example
List<String> list = new ArrayList<>();
list.add("A");
list.add("C");

ListIterator<String> it = list.listIterator();

while (it.hasNext()) {
    String val = it.next();

    if (val.equals("A")) {
        it.add("B");   // adds after A, before C
    }
}

System.out.println(list);
Output
[A, B, C]



1. Arrays.asList()



Used to convert an array or values into a fixed-size list.

List<String> names = Arrays.asList("A", "B", "C");
Features:
Size cannot be changed (no add() or remove()).
You can modify existing elements using set().
names.set(0, "X");   // Works
names.add("D");      // Error
2. List.of()

Introduced in Java 9. Used to create an immutable list.

List<String> names = List.of("A", "B", "C");
Features:
Cannot add, remove, or modify anything.
Fully read-only.
names.set(0, "X");   // Error
names.add("D");      // Error



Feature	Iterator	ListIterator
Works with	All Collections	Only List (ArrayList, LinkedList)
Direction	Forward only	Forward + Backward
Methods	hasNext(), next(), remove()	All iterator methods + more
Previous Element	❌ No	✅ previous()
Add Element While Iterating	❌ No	✅ add()
Replace Element	❌ No	✅ set()
Index Info	❌ No	✅ nextIndex(), previousIndex()


*******************
Yes — you can remove elements while iterating using Iterator, but only by using iterator.remove().




ArrayList Deep Dive
Internal Working

Uses dynamic array internally.

Default capacity = 10 (Java 8+ first add creates)

When full:

newCapacity = old + old/2



Time Complexity
Operation	Time
get()	O(1)
add() end	O(1)
insert middle	O(n)
remove middle	O(n)



When Use ArrayList?
Frequent read
Less insertion in middle
Index access needed


LinkedList Deep Dive

Doubly linked list.

Each node has:

prev | data | next
Example
LinkedList<String> list = new LinkedList<>();
list.add("A");
list.addFirst("B");
list.addLast("C");

System.out.println(list);

Output:

[B, A, C]
Time Complexity
Operation	Time
get(index)	O(n)
addFirst	O(1)
addLast	O(1)
removeFirst	O(1)
removeLast()
Use Case
Frequent insert/delete
Queue implementation


Feature	ArrayList	LinkedList
Structure	Dynamic Array	Doubly Linked
Random Access	Fast	Slow
Insert Middle	Slow	Faster
Memory	Low	High




-________________________________________-SET Interface

No duplicates.

Implementations:

HashSet
LinkedHashSet
TreeSet

Set<String> set = new HashSet<>();
set.add("Java");
set.add("Java");
set.add("Spring");

System.out.println(set);


Important Properties of HashSet
Stores unique elements only
Duplicate values are ignored
Allows one null
Unordered (no guaranteed iteration order)
Internally uses hashing



TreeSet

Sorted set.

TreeSet<Integer> set = new TreeSet<>();
set.add(50);
set.add(10);
set.add(30);

System.out.println(set);

Output:

[10,30,50]

Uses Red Black Tree.





1. Fail-Fast Example (ArrayList)***********************************************88
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> it = list.iterator();

        while(it.hasNext()) {
            String val = it.next();

            if(val.equals("B")) {
                list.add("X");   // structural modification
            }

            System.out.println(val);
        }
    }
}
A
B
Exception in thread "main" java.util.ConcurrentModificationException

Why it happens

ArrayList iterator stores an internal value called expectedModCount.

Collection has modCount.

When you do:

list.add("X");

modCount changes.

Iterator compares:

expectedModCount != modCount

Mismatch detected → throws ConcurrentModificationException.



3. Fail-Safe Example (CopyOnWriteArrayList)
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list =
            new CopyOnWriteArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> it = list.iterator();

        while(it.hasNext()) {
            String val = it.next();

            if(val.equals("B")) {
                list.add("X");   // allowed
            }

            System.out.println(val);
        }

        System.out.println(list);
    }
}
Output
A
B
C
[A, B, C, X]
Why no exception?

Iterator reads a snapshot copy taken when iterator was created.

So current iteration sees:

A B C



Yes — if you modify using ListIterator’s own methods, it usually won’t throw ConcurrentModificationException.

That is because ListIterator updates the iterator’s internal state (expectedModCount) when it performs the change.


Object
   ↓
AbstractCollection
   ↓
AbstractList
   ↓
Vector
   ↓
Stack



MAP Interface

Stores key-value pair.

Map<Integer,String> map = new HashMap<>();
map.put(1,"Java");
map.put(2,"Spring");
Important Map Methods
put()
putIfAbsent()
get()
getOrDefault()
remove()
containsKey()
containsValue()
replace()
computeIfAbsent()
computeIfPresent()
merge()
entrySet()
keySet()
values()

These methods are mainly used with Java Map implementations like:

HashMap
LinkedHashMap
TreeMap
Hashtable
ConcurrentHashMap



1. put(key, value)

Adds new key-value pair or updates existing key.

map.put("java", 100);
map.put("python", 200);

If key already exists:
map.put("java", 500);
Old value replaced.
Returns:
old value if key existed
null if new key


Map<String, Integer> map = new HashMap<>();  ******
System.out.println(map.put("java", 100));  //it return null
System.out.println(map.put("python", 200));//it reutrns null
System.out.println(map.put("java", 500));//it returns 100
does two things:
Inserts the key-value pair into the map.
Returns the previous value associated with that key. 


2. putIfAbsent(key, value)

Adds only if key is missing or mapped to null.

map.putIfAbsent("java", 999);

If "java" already exists → no overwrite.

Trick

Use when you want default insert without replacing existing value.





3. get(key)

Returns value for key.

map.get("java");

If key not found:

null
Fresher Mistake

Thinking null means key absent always. Wrong. Key may exist with null value.

Use containsKey().



4. getOrDefault(key, defaultValue)
*******************
If key exists → return value
Else return default.

map.getOrDefault("c++", 0);

Output:

0

Very useful in frequency counting.




5. remove(key)

Deletes key.

map.remove("java");

Returns removed value or null.



6. containsKey(key)

Checks if key exists.

map.containsKey("java");

Returns boolean.

Use when get() can return null.

7. containsValue(value)

Checks if any key has this value.

map.containsValue(100);

Slower than containsKey() usually, because values must be searched.

8. replace(key, value)

Replace only if key exists.

map.replace("java", 700);

If key absent → nothing happens.

Overloaded
map.replace("java", 100, 700);

Replace only if current value = 100.

9. computeIfAbsent(key, function)

If key missing, compute value and insert.

map.computeIfAbsent("java", k -> 50);

If "java" absent → adds java=50

If present → no recompute.

Best Use

Grouping, caching, lists in maps.

map.computeIfAbsent("A", k -> new ArrayList<>());
10. computeIfPresent(key, function)

Runs only if key exists.

map.computeIfPresent("java", (k,v) -> v + 10);

If java=100

Becomes:

110

If key absent → nothing.

11. merge(key, value, remappingFunction)

If key absent → insert given value
If present → combine old + new using function.

map.merge("java", 1, Integer::sum);

If absent:

java=1

If already java=5

Then:

5 + 1 = 6
Excellent for frequency count
map.merge(word, 1, Integer::sum);
12. entrySet()

Returns set of key-value entries.

Best way to iterate.

for(Map.Entry<String,Integer> e : map.entrySet()) {
    System.out.println(e.getKey()+" "+e.getValue());
}
13. keySet()

Returns set of keys.

map.keySet();

Use when only keys needed.

14. values()

Returns collection of all values.

map.values();

Duplicates allowed.

Full Example
Map<String,Integer> map = new HashMap<>();

map.put("java", 10);
map.putIfAbsent("python", 20);
map.putIfAbsent("java", 99);

System.out.println(map.get("java"));
System.out.println(map.getOrDefault("c++",0));

map.replace("java", 50);

map.merge("java", 5, Integer::sum);

System.out.println(map);

Output:

10
0
{java=55, python=20}



**********************************************
Q2: Difference between get() and getOrDefault()?

Answer:
get() returns null if absent.
getOrDefault() returns provided default value.

Example 1: Key exists
Map<String,Integer> map = new HashMap<>();
map.put("java", 100);

System.out.println(map.remove("java"));

Output:

100


Q2: Difference between hashCode() and equals()?

Answer:
hashCode() chooses bucket. equals() verifies exact key.


HASHMAP INTERNAL WORKING *************************************

Step 3: Calculate Bucket Index

If current capacity = 16

Then Java calculates:

index = (n - 1) & hash

HashMap internally uses an array of buckets. During put, it calculates the key’s hashCode, mixes bits, derives a bucket index, and stores the key-value node there. If multiple keys map to the same bucket, collisions are handled using linked lists or Red-Black trees in Java 8+. During get, the same hash process locates the bucket, and equals() identifies the exact key. When size crosses capacity × load factor, HashMap resizes and rehashes entries for better performance.

Internally:
hashCode() → choose bucket
equals() → identify exact key in bucket


3. What is hashCode()?

Returns an integer hash value representing the object.

System.out.println(a.hashCode());

Used by hash-based collections to decide bucket location.

Why Needed?

Without hash, collections would need linear search.

With hash:
faster lookup
faster insert
better indexing



1. What is Sorting?

Sorting means arranging data in order:

Ascending
Descending
Alphabetical
Custom logic



2. What is Comparable?

Comparable is an interface used to define natural/default sorting order of objects.
uses Java’s internal sorting algorithm (TimSort for object lists),
Package
java.lang.Comparable

(java.lang imported automatically)

Method
int compareTo(T o)
Meaning of Return Values
negative  -> current object smaller
zero      -> equal
positive  -> current object greater
Example: Integer Uses Comparable
5.compareTo(10)   // negative
10.compareTo(5)   // positive
10.compareTo(10)  // zero


Example:

(3 ram).compareTo(1 laksh)

This runs:

3 - 1 = 2

Positive result means:

1 laksh should come before 3 ram

So Java reorders them.


3. What is Comparator?

Comparator is used for custom sorting logic.

Package
java.util.Comparator
Method
int compare(T o1, T o2)
Why Needed?

When:

class already exists
multiple sorting logics needed
cannot modify source code
sort by name, age, salary etc.


4: Can one class have multiple sorting logics using Comparable?  *******************
Answer: No practical default only one. Use Comparator for multiple logics.


Q5: Which is better in modern Java?
Answer: Comparator with lambda expressions.


Core Difference
Feature	        Comparable	                Comparator
Package	        java.lang	                java.util
Method	        compareTo()	                compare()
Logic           placed in	same class	    separate class/lambda
Sorting         typenatural/default	        custom
Number of logics	one main logic      	many


9. Multiple Comparator Chaining  ******************
list.sort(
 Comparator.comparing(Student::getName)
           .thenComparing(Student::getId)
);

Sort by:

name
if same name → id


❌ Mistake 1
return this.id - s.id;

May overflow for large numbers.

Better:

return Integer.compare(this.id, s.id);




Yes — but the compare method is still being used implicitly.************************  for comparator 
You wrote:

Collections.sort(list, (a,b) -> a.id - b.id);

That lambda expression is automatically converted into a Comparator object.





Collections Utility Class

Methods:

sort()
reverse()
shuffle()
max()
min()
binarySearch()
frequency()
disjoint()
synchronizedList()
unmodifiableList()


 Set<Integer> set=new HashSet<>(list);
       System.out.println(set);
       Iterator<Integer> it=set.iterator();
       while (it.hasNext()) {
        System.out.println(it.next());
        set.add(4);
        
       }   // it dont throw concurrent modificationexception if the element is already present in this set


Why Two Forms Exist
1. Old Style
Collections.sort(list, comparator);

Static utility method from Collections.

2. Modern Style (Java 8+)
list.sort(comparator);

Default method on List interface.

Same Meaning

Both sort the list using the comparator you provide.

Short Interview Answer

list.sort(...) internally uses a comparator, same purpose as Collections.sort(list, comparator).


Ascending Order Example
Employee Class
class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return name + " - " + salary;
    }
}
Main Program
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Ravi", 50000));
        employees.add(new Employee("Asha", 30000));
        employees.add(new Employee("John", 70000));

        employees.sort((a,b) -> Double.compare(a.salary, b.salary));

        System.out.println(employees);
    }
}
Output
[Asha - 30000.0, Ravi - 50000.0, John - 70000.0]



Better Modern Version****************************************
Use method reference style:
employees.sort(Comparator.comparingDouble(e -> e.salary));
employees.sort(Comparator.comparingDouble((Employee e) -> e.salary).reversed());


[Ravi(50000), Asha(30000), John(70000)]

During sorting, Java may compare pairs like this:

Comparison 1
a = Ravi
b = Asha

Then:

Double.compare(50000, 30000)

Result = positive

Meaning Ravi salary is bigger, so Ravi should come after Asha.

Comparison 2
a = Asha
b = John

Then:

Double.compare(30000, 70000)

Result = negative

Meaning Asha should come before John.



Why Set uses HashMap internally?*******************8
Because uniqueness based on key uniqueness.

Interviewer: Which collection used in caching?
Answer:
LinkedHashMap for LRU cache
ConcurrentHashMap for multi-thread cache


Important Interview Question
Difference between synchronizedList() and unmodifiableList()
synchronizedList()	unmodifiableList()
Thread safe	        Read only
Can modify	        Cannot modify


| Map Type            | Thread Safe? |
| ------------------- | ------------ |
| `HashMap`           | ❌ No         |
| `LinkedHashMap`     | ❌ No         |
| `TreeMap`           | ❌ No         |
| `Hashtable`         | ✅ Yes        |
| `ConcurrentHashMap` | ✅ Yes        |


*******************************************
HashMap is not thread-safe because it has no internal synchronization.
When multiple threads access and modify it simultaneously, operations like put(), get(), resize(), and rehashing can interleave, causing:

data inconsistency
lost updates
corrupted internal structure
infinite loops (older JDK resize issues)
unpredictable results
Why?

HashMap is designed for high single-thread performance, so Java did not add locking overhead.



Collection
   └── Set
        ├── SortedSet
        │     └── NavigableSet
        └── HashSet / LinkedHashSet / TreeSet (classes)
1. Set

A collection of unique elements (no duplicates).

Set<Integer> set = new HashSet<>();
set.add(5);
set.add(2);
set.add(5);   // duplicate ignored

System.out.println(set); // [2, 5]
2. SortedSet

A Set that keeps elements in sorted order (ascending by default).

Usually implemented by TreeSet.

SortedSet<Integer> numbers = new TreeSet<>();

numbers.add(30);
numbers.add(10);
numbers.add(20);

System.out.println(numbers); // [10, 20, 30]
System.out.println(numbers.first()); // 10
System.out.println(numbers.last());  // 30

*****************************
A Map does not allow duplicate keys, although duplicate values are allowed. In a HashMap, only one null key is permitted because null is handled separately in a special bucket. A TreeMap does not allow null keys because it uses sorting and comparison.




______________________________**********************************************_____________________________
IF WE ADD SET.ADD(5) THEN WE SHOULD DO MODULUS TO FIND THE INDEXT LIKE 16)5(0  ->5  SO 5 WILL STORE IN 5TH INDEX BUCKET  IF TWO ELEMENTS ARE STORED IN SAME BUCKET THEN HASH COLLISIOIN THEN IT WILL USE LINKEDLIST SO THAT IT WILL CREATE NODES AND LINKS LIKE NEXT IF WE EXCEED 8 BUCKETS THEN IT WILL USE REDBLACK TREE    correct this in detail
When we call set.add(5), the HashSet first computes the hash code of the element and then uses a modulus / bit-masking operation to determine the bucket index where the element should be stored.

For example, if the internal table size is 16, the calculated bucket index for 5 may map to bucket 5 (implementation depends on the hashing formula). So the element 5 is stored in the bucket at index 5.

If two different elements map to the same bucket index, this is called a hash collision. In that case, both elements are stored in the same bucket.

In older implementations, collisions were handled using a Linked List:

Each bucket stores the first node.
Additional collided elements are added as nodes connected through next references.

If too many elements accumulate in one bucket, lookup performance becomes slower.

In modern Java HashMap / HashSet implementations, when the number of nodes in a single bucket exceeds a threshold (typically 8) and the table capacity is large enough (at least 64), the linked list is converted into a Red-Black Tree.

A Red-Black Tree is a self-balancing binary search tree that improves search, insert, and delete performance in that bucket from approximately O(n) to O(log n).

Corrected Summary
set.add(5) is called.
Hash is calculated for 5.
Bucket index is found using table size.
5 is stored in that bucket.
If another element maps to the same bucket → collision occurs.
Elements are first stored as a linked list.
If bucket node count becomes more than 8 (with sufficient capacity), it converts to a Red-Black Tree.


Map does not prevent collisions. It prevents duplicate keys.*************************************

***********************************
Those are two different concepts:

1. Duplicate Key

A duplicate means the same key is inserted again.

Example in HashMap:

map.put("A", 10);
map.put("A", 20);

Here key "A" already exists, so the second insert replaces the old value.

Result:

{A=20}

No duplicate key is stored.

2. Collision

A collision means different keys produce the same bucket index.

Example:

key1 = "FB"
key2 = "Ea"

These different strings are famous because they can generate the same hash code in Java.

So:

"FB" ≠ "Ea" (different keys)
But both may go to the same bucket

That is a collision.



*****************************************
Internal Process
Step 1: Calculate Hash

For the new key, Java computes:

hash = key.hashCode()

Example:

"FB".hashCode()
"Ea".hashCode()

These may produce the same hash.

Step 2: Find Bucket Index

Java calculates index:

index = (n - 1) & hash

Where n = table size (like 16)

If both keys get index 5, both go to bucket 5.

Step 3: Check Bucket

If bucket 5 is empty:

insert directly

If bucket 5 already has node(s):

collision detected

Because another key is already there.

Step 4: Compare Existing Keys

Java traverses linked list/tree in that bucket and checks:

if (existing.hash == newHash &&
   (existing.key == key || key.equals(existing.key)))
Two Cases:
Case A: Same Key
map.put("A",1);
map.put("A",2);

Same key found → update value.

Case B: Different Key Same Bucket
map.put("FB",1);
map.put("Ea",2);

Different key, same index → collision → add new node.

Important Point

Collision is detected when:

Target bucket already contains another entry, but key is different.

Visual Example

Bucket 5:

Before:

[FB=1]

Add "Ea":

Same bucket
Different key

After:

[FB=1] -> [Ea=2]
Final Answer

During put() or add(), HashMap:

Calculates hash
Finds bucket index
Checks if bucket already has data
If yes, compares keys
Different key = collision
Same key = replace value





Java roughly does:

Compute hashCode()
Find bucket index
Go to that bucket
If bucket has entries, compare with existing nodes:
hash same?
then equals() check key equality
Why equals() Is Needed

Many different objects can:

have same bucket index
even same hash code

So Java cannot trust hash alone.

It uses equals() to confirm whether keys represent the same key.

















***********************
1. Capacity

Capacity = number of buckets (array slots) inside the HashMap.

HashMap stores entries in an internal array of buckets.

If capacity = 16, there are 16 bucket positions.

HashMap<Integer, String> map = new HashMap<>();

Default initial capacity is usually 16.

Visual
Index:   0   1   2   3   4 ... 15
        [ ] [ ] [ ] [ ] [ ] ... [ ]

Each bucket can hold nodes/entries.

2. Load Factor

Load factor = percentage of capacity allowed before resize.

Default:

0.75

Means when HashMap becomes 75% full, it expands.

Why not 100%?

Because too many entries increase collisions and slow performance.

So Java balances:

memory usage
speed
3. Threshold

Threshold = capacity × load factor

When size exceeds threshold, HashMap resizes.

Default HashMap Example
HashMap<Integer, String> map = new HashMap<>();

Default values:

Capacity = 16
Load Factor = 0.75
Threshold = 16 × 0.75 = 12

So when you add the 13th element, resize happens.

Resize Process

When threshold exceeded:

capacity doubles
16 -> 32

New threshold:

32 × 0.75 = 24

Next resize at 25th insertion.









Default:

Capacity = 16 buckets
Load Factor = 0.75

So threshold is:

16×0.75=12

That means HashMap allows 12 entries safely before resizing.

What happens when adding elements?
Insert 1st to 12th element

No resize.

size = 1 ... 12
capacity = 16

Still same internal bucket array.

Insert 13th element

Now size becomes 13, which crossed threshold 12.

So HashMap says:

Too full. Increase buckets.

Then resize happens:

capacity: 16 -> 32
After Resize

Now HashMap recalculates threshold:

32×0.75=24

So new threshold = 24

Meaning:

Up to 24 entries = no resize
When adding 25th element = resize again
Timeline
Inserted Elements	Capacity	Threshold	Resize?
1 to 12	16	12	No
13	32	24	Yes
14 to 24	32	24	No
25	64	48	Yes

***********************************

Because HashMap resize rule is: when expansion happens, capacity usually doubles.

So:

16 -> 32
32 -> 64
64 -> 128



Common Implementations**************************************
Map Type	Thread Safe?
HashMap	❌ No
LinkedHashMap	❌ No
TreeMap	❌ No
Hashtable	✅ Yes
ConcurrentHashMap	✅ Yes


Why Set uses HashMap internally?*******************8
Because uniqueness based on key uniqueness.


HashMap is not thread-safe because it has no internal synchronization.*****************************
When multiple threads access and modify it simultaneously, operations like put(), get(), resize(), and rehashing 
can interleave, causing:
data inconsistency
HashMap is designed for high single-thread performance, so Java did not add locking overhead.



Interviewer: Which collection used in caching?
Answer:
LinkedHashMap for LRU cache
ConcurrentHashMap for multi-thread


*********************************
3. Why HashMap Allows One Null Key

Because null has no hashCode().

Java reserves bucket index 0 for null key.

map.put(null, "value");

Only one null key because keys must be unique.




*****************************8
Why TreeMap does not allow null key?

TreeMap sorts keys using:

natural ordering (Comparable)
or
Comparator

To compare keys, it needs ordering. null cannot be compared naturally, so by default:

TreeMap<String, Integer> tm = new TreeMap<>();
tm.put(null, 1); // Exception

Throws:

NullPointerException
But note:

If you provide a custom comparator that handles nulls, TreeMap can support null keys in some cases.


******************************
HASHMAP INTERNAL TABLE CONTAINS 0-15BUCKETS   
IF WE ADD SET.ADD(5) THEN WE SHOULD DO MODULUS TO FIND THE INDEXT LIKE 16)5(0  ->5  SO 5 WILL STORE IN 5TH INDEX BUCKET  IF TWO ELEMENTS ARE STORED IN SAME BUCKET THEN HASH COLLISIOIN THEN IT WILL USE LINKEDLIST SO THAT IT WILL CREATE NODES AND LINKS LIKE NEXT IF WE EXCEED 8 BUCKETS THEN IT WILL USE REDBLACK TREE



When we call set.add(5), the HashSet first computes the hash code of the element and then uses a modulus / bit-masking operation to determine the bucket index where the element should be stored.

For example, if the internal table size is 16, the calculated bucket index for 5 may map to bucket 5 (implementation depends on the hashing formula). So the element 5 is stored in the bucket at index 5.

If two different elements map to the same bucket index, this is called a hash collision. In that case, both elements are stored in the same bucket.

In older implementations, collisions were handled using a Linked List:

Each bucket stores the first node.
Additional collided elements are added as nodes connected through next references.

If too many elements accumulate in one bucket, lookup performance becomes slower.

In modern Java HashMap / HashSet implementations, when the number of nodes in a single bucket exceeds a threshold (typically 8) and the table capacity is large enough (at least 64), the linked list is converted into a Red-Black Tree.

A Red-Black Tree is a self-balancing binary search tree that improves search, insert, and delete performance in that bucket from approximately O(n) to O(log n).

Corrected Summary
set.add(5) is called.
Hash is calculated for 5.
Bucket index is found using table size.
5 is stored in that bucket.
If another element maps to the same bucket → collision occurs.
Elements are first stored as a linked list.
If bucket node count becomes more than 8 (with sufficient capacity), it converts to a Red-Black Tree.

present=new object() ************** if we add set.add(5) it will call map.put(5,present)

2. Collision

A collision means different keys produce the same bucket index.*******



___________________*****************************************__________________________

Internal Process
Step 1: Calculate Hash

For the new key, Java computes:

hash = key.hashCode()

Example:

"FB".hashCode()
"Ea".hashCode()

These may produce the same hash.

Step 2: Find Bucket Index

Java calculates index:

index = (n - 1) & hash

Where n = table size (like 16)

If both keys get index 5, both go to bucket 5.

Step 3: Check Bucket

If bucket 5 is empty:

insert directly

If bucket 5 already has node(s):

collision detected

Because another key is already there.

Step 4: Compare Existing Keys

Java traverses linked list/tree in that bucket and checks:

if (existing.hash == newHash &&
   (existing.key == key || key.equals(existing.key)))
Two Cases:
Case A: Same Key
map.put("A",1);
map.put("A",2);

Same key found → update value.

Case B: Different Key Same Bucket
map.put("FB",1);
map.put("Ea",2);

Different key, same index → collision → add new node.

Important Point

Collision is detected when:

Target bucket already contains another entry, but key is different.



Compute hashCode()
Find bucket index
Go to that bucket
If bucket has entries, compare with existing nodes:
hash same?
then equals() check key equality
Why equals() Is Needed

Many different objects can:

have same bucket index
even same hash code

So Java cannot trust hash alone.

It uses equals() to confirm whether keys represent the same key.





*****************************************************************
1. Capacity

Capacity = number of buckets (array slots) inside the HashMap.

HashMap stores entries in an internal array of buckets.

If capacity = 16, there are 16 bucket positions.

HashMap<Integer, String> map = new HashMap<>();

Default initial capacity is usually 16.

Visual
Index:   0   1   2   3   4 ... 15
        [ ] [ ] [ ] [ ] [ ] ... [ ]

Each bucket can hold nodes/entries.

2. Load Factor

Load factor = percentage of capacity allowed before resize.

Default:

0.75

Means when HashMap becomes 75% full, it expands.

Why not 100%?

Because too many entries increase collisions and slow performance.

So Java balances:

memory usage
speed
3. Threshold

Threshold = capacity × load factor

When size exceeds threshold, HashMap resizes.

Default HashMap Example
HashMap<Integer, String> map = new HashMap<>();

Default values:

Capacity = 16
Load Factor = 0.75
Threshold = 16 × 0.75 = 12

So when you add the 13th element, resize happens.

Resize Process

When threshold exceeded:

capacity doubles
16 -> 32

New threshold:

32 × 0.75 = 24

Next resize at 25th insertion


Default:

Capacity = 16 buckets
Load Factor = 0.75

So threshold is:

16×0.75=12

That means HashMap allows 12 entries safely before resizing.

What happens when adding elements?
Insert 1st to 12th element

No resize.

size = 1 ... 12
capacity = 16

Still same internal bucket array.

Insert 13th element

Now size becomes 13, which crossed threshold 12.

So HashMap says:

Too full. Increase buckets.

Then resize happens:

capacity: 16 -> 32
After Resize

Now HashMap recalculates threshold:

32×0.75=24

So new threshold = 24

Meaning:

Up to 24 entries = no resize
When adding 25th element = resize again
Timeline
Inserted Elements	Capacity	Threshold	Resize?
1 to 12	16	12	No
13	32	24	Yes
14 to 24	32	24	No
25	64	48	Yes


*************************************************
Because HashMap resize rule is: when expansion happens, capacity usually doubles.

So:

16 -> 32
32 -> 64
64 -> 128

It does not increase by +1 or +10. It multiplies by 2.

********************************************************
Simple Example

Initial:

capacity = 16
threshold = 12

When you insert 13th element:

size = 13 > threshold = 12

So resize:

16×2=32

New capacity = 32

Then new threshold:

32×0.75=24

**********************
for arraylist
2. Default Capacity
In modern Java versions:
new ArrayList<>()
When first element is added, capacity becomes:
10
All these represent roughly the same growth logic:
oldCapacity * 3 / 2
oldCapacity + oldCapacity / 2
oldCapacity + (oldCapacity >> 1)
Time Complexity
Operation	Time
get()	O(1)
add(end)	O(1) amortized
insert middle	O(n)
remove middle	O(n)



******************************************8
What is LinkedList?

Doubly linked list implementation.
Why Use LinkedList?

Best when:

Frequent insertion/deletion
Add/remove at ends
Queue usage


Methods
addFirst()
list.addFirst("X");
addLast()
removeFirst()
removeLast()
getFirst()
getLast()

**********************************
What is Vector?

Vector is a legacy dynamic array class in Java.

It is similar to ArrayList, but thread-safe because methods are synchronized.

Vector<String> v = new Vector<>();


Why Vector Came?

Before Java Collections modernization, Vector was used as resizable array.
Later ArrayList introduced for better performance.

Why Vector Slower?

Because methods use synchronized. public synchronized boolean add(E e)

addElement() **************Legacy method.
elementAt(index)
v.elementAt(0);
firstElement()
lastElement()
removeElement()

**********************************************************
A Stack is a linear data structure that follows the LIFO principle — Last In, First Out. It means the element inserted most recently is removed first.

Example: like a stack of plates. The last plate placed on top is the first one removed.

Core operations are:

push() → insert element on top
pop() → remove top element
peek() → view top element without removing
isEmpty() → check whether stack has elements

In Java, Stack can be implemented using:******************

Array
Linked List
Stack class (legacy)
Deque (ArrayDeque) → preferred modern approac
Deque<Integer> stack = new ArrayDeque<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.pop()); // 30
System.out.println(stack.pop()); // 20

1. Stack Class Is Legacy*****************
Java’s Stack class extends Vector, so it is older and synchronized***
Deque<Integer> stack = new ArrayDeque<>();

2. Real-World Uses of Stack

Mention practical use:

Function call stack / recursion
Undo/redo systems
Browser back/forward history

********************************88
Key Point: ArrayDeque is not just a Queue
ArrayDeque means:
Array + Deque
And Deque stands for:
Double Ended Queue
It allows insertion/removal from both ends.
So it can behave as:
Queue (FIFO)
Stack (LIFO)


vector is parent and stack is child because stack extends vector



*****************************************************************************************************
How Deque Performs Stack Operations

Use one end only (usually front):

Stack Operation	Deque Method
push(x)	push(x) / addFirst(x)
pop()	pop() / removeFirst()
peek()	peek() / peekFirst()







SET
A Set is a collection in Java that stores unique elements, meaning it does not allow duplicate values.
Unlike List, Set does not support index-based access, and ordering depends on the implementation.

Core Characteristics
no order
no indexing
No duplicate elements
Stores objects only
No get(index) method
Allows at most one null in some implementations
Fast lookup in certain implementations

Why Use Set?
Use when uniqueness required.
Examples:
Unique emails
Unique usernames


What is HashSet?

Most used Set implementation.

Internally uses:

HashMap

Each element stored as key in HashMap.

HashSet<String> set = new HashSet<>();
Why No Duplicates?

Because HashMap keys cannot duplicate.



Important Methods
add()
Returns boolean.
set.add("A");
If duplicate → false
remove()
contains()
isEmpty()
size()
clear()


5. LINKEDHASHSET
What is LinkedHashSet?
Same as HashSet but maintains insertion order.
Why Order Maintained?
Uses linked list internally along with hash table.

6. TREESET
What is TreeSet?
Sorted Set implementation.
Stores elements in sorted order.
Internal Structure
Uses:
Red Black Tree



first()
last()
higher(x)

Greater than x.

lower(x)

Less than x.

ceiling(x)

= x

floor(x)

<= x

Example
TreeSet<Integer> ts = new TreeSet<>();

ts.add(10);
ts.add(20);
ts.add(30);

System.out.println(ts.higher(20));

Output:
30


Can two unequal objects have same hashCode?
Yes.
Called collision.





********************************************************************************************
When equals() Is Used in put()

If another key already exists in same bucket:

Compare hash
Compare keys
if (k == key || key.equals(k))

If equal:

replace old value

If not equal:

add new node in chain/tree



Preserve order + unique
LinkedHashSet<String> set = new LinkedHashSet<>();

set.add("B");
set.add("A");
set.add("B");
System.out.println(set);


Which Set to choose?
Fast unique lookup → HashSet
Need insertion order → LinkedHashSet
Need sorted data → TreeSet





*********************************************map*****************************************
A Map is a collection framework data structure that stores elements in the form of key and value pairs. Each key is unique, and it is used to retrieve the corresponding value efficiently. If we insert a duplicate key, the old value gets replaced by the new value.

Maps are widely used in real-world applications such as storing employee records using employee ID as key, product details using product code, caching systems, dictionaries, and configuration settings.

Important Features of Map
Stores data as Key → Value
Keys must be unique
Values can be duplicate (depends on language/framework)
Provides fast searching using key
Useful for large datasets
Use these smart lines:

✅ “Map is preferred when data retrieval by key needs to be optimized.”

✅ “Choosing the right Map implementation depends on requirements like ordering, sorting, and thread safety.”

✅ “In enterprise applications, Map is heavily used for caching, indexing, and configuration management.”


employeeId → employeeName
username → password
countryCode → countryName
productId → productDetails
word → frequency count


Why Map Is Not Child of Collection?*****************************
Because Collection stores only values:
[A, B, C]
Map stores pair:
(key,value)
Different structure.


Step 1

Calls:

101.hashCode()
Step 2

Converts hash to bucket index.

index = hash & (n - 1)

(n = capacity)

Step 3

Go to bucket.

Step 4

If empty → insert node.

Step 5

If same key exists → replace value.

Step 6

If collision → linked list/tree.

****************************************
Why Only One Null Key?

Because key uniqueness.

treemap***********************8
Useful Methods
firstKey()
lastKey()
higherKey(x)
lowerKey(x)
ceilingKey(x)
floorKey(x)


*****************************************
What is Hashtable?

Legacy synchronized map.

Hashtable<Integer,String> table = new Hashtable<>();
Features
Thread safe
No null key
No null value
Legacy class
Slower than HashMap
Modern Replacement

Use:

ConcurrentHashMap






11. CONCURRENTHASHMAP
What is It?

Thread-safe high performance map.

Used in multi-threaded apps.

ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<>();




Why Better Than Hashtable?************************************

Hashtable locks whole map.

ConcurrentHashMap uses fine-grained locking / advanced concurrency



12. WEAKHASHMAP
What is It?
Keys stored with weak references.
If key has no strong reference elsewhere:
GC can remove entry


Best Method
for(Map.Entry<Integer,String> e : map.entrySet()){
   System.out.println(e.getKey()+" "+e.getValue());
}
Using Lambda
map.forEach((k,v) -> System.out.println(k+" "+v));



| HashMap          | Hashtable    |
| ---------------- | ------------ |
| Not synchronized | Synchronized |
| Allows null      | No null      |
| Fast             | Slower       |









A Queue is a linear data structure that follows the FIFO (First In, First Out) principle. This means the element inserted first will be removed first.

It works like a real-life queue, such as people waiting in line at a ticket counter. The first person in line is served first.

Main Operations of Queue
add() / offer() → insert element at rear
remove() / poll() → remove element from front
element() / peek() → view front element without removing

Real-Time Uses
Printer task scheduling
CPU job scheduling
Call center waiting systems


********************************************
Queue is an interface.

Common classes implementing Queue:
LinkedList
PriorityQueue
ArrayDeque
BlockingQueue implementations


add() throws exception if full
offer() returns false
Difference remove() vs poll()
remove() throws exception if empty
poll() returns null
Difference element() vs peek()
element() throws exception if empty
peek() returns null



2. Deque (Double Ended Queue)

Deque = queue with insertion/removal at both ends.

import java.util.Deque;

You can:

insert front
insert rear
remove front
remove rear
Deque Methods

| Method        | Meaning      |
| ------------- | ------------ |
| addFirst()    | insert front |
| addLast()     | insert rear  |
| removeFirst() | remove front |
| removeLast()  | remove rear  |
| peekFirst()   | front        |
| peekLast()    | rear         |

3. PriorityQueue

A special queue where elements are ordered by priority.

Default:

Min Heap

Smallest comes first.




**********************************
5. BlockingQueue

Used in Multithreading

Package:

import java.util.concurrent.*;

Thread-safe queue.

If queue empty:

consumer waits

If queue full:

producer waits


wee need comparable for custom object sorting ***********************************************



Why Use Comparator?

When multiple sorting rules needed.

Example Employee can be sorted by:

id
name
salary
age

Comparable gives one default rule only.

Comparator gives unlimited rules.

Example: Sort by Name
Comparator<Employee> byName =
(a,b) -> a.name.compareTo(b.name);

Collections.sort(list, byName);