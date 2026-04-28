import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class col2 {
    public static void main(String[] args) {


        //  removing duplicates
    //     List<Integer> list=Arrays.asList(1,2,2,3,4,5);
    //    Set<Integer> set=new HashSet<>(list);
    //    System.out.println(set);
    //    Iterator<Integer> it=set.iterator();
    //    while (it.hasNext()) {
    //     System.out.println(it.next());
    //     set.add(4);
        
    //    }


   //counting frequency
//    String s="banana";

// Map<Character,Integer> map = new HashMap<>();

// for(char c:s.toCharArray()){
//  map.put(c,map.getOrDefault(c,0)+1);
// }

// System.out.println(map);
// for(Map.Entry<Character,Integer> entry:map.entrySet())
// {
//     System.out.println(entry.getKey()+" "+entry.getValue());
// }

Set<Integer> set=new HashSet<>();
// System.out.println(set.add(1));
System.out.println(set.add(1));
if(!set.add(2))
{
    System.out.println("hello");
}
else{
    System.out.println("not executed");
}
System.out.println(set);


    }
}
