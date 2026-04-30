import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class col3 {

    public static void main(String[] args) {
        // List<Integer> list=new ArrayList<>(Arrays.asList(10,20,30));
        // Iterator<Integer> it=list.iterator();
        // while (it.hasNext()) {
        //     Integer n=it.next();
        //     // System.out.println(n);
        //     if(n==30)
        //     {
        //         it.remove();
        //     }
        //     System.out.println(n);
        // }
        // System.out.println(list);

        // List<String> lists = new ArrayList<>(Arrays.asList("A","B"));

        // ListIterator<String> its =
        // lists.listIterator();

        // while(its.hasNext()){
        //     String s = its.next();

        //     if(s.equals("B")){
        //         its.set("BB");
        //     }
        // }

        // System.out.println(lists);


        // List<Integer> list=new ArrayList<>(List.of(1,2,3,4));
        // list.forEach(System.out::println);
        // list.forEach((a)->System.out.println(a));


                List<Integer> list=new ArrayList<>(List.of(1,2,3,4,5,6,7,8));
                list.removeIf(n -> n % 2 == 0);
                System.out.println(list);
    }
}