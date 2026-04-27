import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Studentcomparator implements Comparable<Studentcomparator> {
int id;
String name;

Studentcomparator(int id,String name)
{
    this.id=id;
    this.name=name;
}


@Override
public int compareTo(Studentcomparator o) {
    // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    return this.id-o.id;   
    // uses Java’s internal sorting algorithm (TimSort for object lists),
}
  public String toString() {
        return id + " " + name;
    }

    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }
    public static void main(String[] args) {
        List<Studentcomparator> list=new ArrayList<>();
        list.add(new Studentcomparator(3,"ram"));
        list.add(new Studentcomparator(1,"laksh"));
        list.add(new Studentcomparator(4,"santhu"));
        list.add(new Studentcomparator(2,"chand"));
        list.add(new Studentcomparator(6,"phani"));
        list.add(new Studentcomparator(7,"sai"));
        list.add(new Studentcomparator(8,"sai"));

        // Collections.sort(list);
        // System.out.println(list);

        Collections.sort(list,(a,b)->a.name.compareTo(b.name));
        System.out.println(list);
        Collections.sort(list, (a,b) -> a.id - b.id);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        Collections.sort(list, (a,b) -> b.id - a.id);
        System.out.println(list);
        Collections.sort(list, (a,b) -> b.name.compareTo(a.name));
        System.out.println(list);

        // 9. Multiple Comparator Chaining
list.sort(
 Comparator.comparing(Studentcomparator::getName)
           .thenComparing(Studentcomparator::getId)
);
System.out.println("last"+list);



// 6. Multiple Sorting

// First by name, then by id.

Collections.sort(list,
    Comparator.comparing((Studentcomparator s) -> s.name)
              .thenComparing(s -> s.id)
);


    }
    
}