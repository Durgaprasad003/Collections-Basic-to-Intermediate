// import java.util.ArrayList;
// import java.util.Collection;
import java.util.*;

public class coll1 {

    public static void main(String[] args) {
        // Collection<String> lis=new ArrayList<>();
        // lis.add("List");
        // lis.add("set");
        // lis.add("queue");
        
        // lis.add("haaa");
        // lis.add("hee hee hee");
        // System.out.println(lis.add("huuu"));
        // System.out.println(lis.remove("haaa"));
        // System.out.println(lis);
        // System.out.println(lis.size());
        // System.out.println(lis.isEmpty());

        // List l=new ArrayList<>();
        // l.add("haa");
        // l.add("hee");
        // l.add("hmm");
        // l.add("huu");
        // l.add(1,"humm");
        //         System.out.println(l);
        // System.out.println(l.get(4));
        // l.set(2, "heehee");
        // System.out.println(l);
        // l.remove(2);
        // System.out.println(l);
        // l.remove("huu");
        // System.out.println(l);
        // System.out.println(l.indexOf("haa"));
        // System.out.println(l.lastIndexOf("hmm"));



        // List<String> lis= new ArrayList<>();
        // lis.add("telugu");
        // lis.add("hindi");
        // lis.add("tamil");
        // lis.add(3,"english");
        // lis.add("maliyalam");
        // System.out.println(lis);

        // List<String> sub=lis.subList(0, lis.size()-1);
        // System.out.println(sub);
        // sub.set(2, "kannada");
        // System.out.println(sub);
        // System.out.println(lis);




// List<String> list = new ArrayList<>(
//     Arrays.asList("A", "B", "C")
// );

// ListIterator<String> li = list.listIterator();

// while(li.hasNext()) {
//     String val = li.next();

//     if(val.equals("B")) {
//         li.add("X");
//     }
// }

// System.out.println(list);


// List<String> list = new ArrayList<>(  ***********************************************
//     Arrays.asList("A", "B", "C")
// );

// ListIterator<String> li = list.listIterator();

// while(li.hasNext()) {
//     String val = li.next();

//     if(val.equals("B")) {
//         li.previous();   // move cursor back before B
//         li.add("X");     // insert before B
//         li.next();       // move again over B (optional for loop flow)
//     }
// }

// System.out.println(list);


// Set<String> set=new HashSet<>();
// System.out.println(set.add(null));
// System.out.println(set.add(null));
// System.out.println(set.add("java"));
// System.out.println(set.add("java"));
// set.add("java");
// set.add("python");
// for(String s:set)
// {
//     System.out.println(s);
// }

// output
// false
// true
// false
// null       It prints null because HashSet allows one null element.
// python
// java



Map<String, Integer> map = new HashMap<>();
// System.out.println(map.put("java", 100));// returns null
// System.out.println(map.put("python", 200));//return nulll
// System.out.println(map.put("java", 500));//returns 100
// for(String key:map.keySet())
// {
//     System.out.println(key);  // it will print keeys
// }
   

for(Map.Entry<String,Integer> e : map.entrySet()) {
    System.out.println(e.getKey()+" "+e.getValue());
}
        
System.out.println(map);




    }
}