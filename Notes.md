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