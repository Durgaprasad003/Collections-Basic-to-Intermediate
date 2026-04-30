import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(1,23,4,5,6,7));
        List<Integer> result = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());//for storing we need collect it will convert to list
        System.out.println(result);
        List<Integer> results = list.stream().filter(n -> n % 2 == 0).map(n -> n * 2).sorted().collect(Collectors.toList());
        System.out.println("hhh"+results);
        // results.stream().map(n->n*4).forEach(System.out::println);//for printing
        results.stream().map(n->n*4).forEach(a->System.out.println(a));//for printing

        List<Integer> list2=new ArrayList<>(Arrays.asList(5,6,7,8));

        List<Integer> resul = Stream.concat(list.stream(), list2.stream()).sorted().collect(Collectors.toList());
        System.out.println(resul);
        List<Integer> resu = Stream.concat(list.stream(), list2.stream()).sorted().distinct().collect(Collectors.toList());
        System.out.println(resu);


                    //         employees.stream()
                    //  .sorted(
                    //    Comparator.comparing(Employee::getSalary)
                    //  )
                    //  .collect(Collectors.toList());


              List<Integer>naam=      list.stream().limit(1).collect(Collectors.toList());

              list.stream().skip(2).collect(Collectors.toList());
    
            System.out.println(naam);


        List<List<Integer>> data = Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4));
            System.out.println(data);
            List<Integer> reult =data.stream().flatMap(List::stream).collect(Collectors.toList());
            System.out.println(reult);


         

Optional<Integer> x =list.stream()  .filter(n -> n > 3).findFirst();

    }
    }
