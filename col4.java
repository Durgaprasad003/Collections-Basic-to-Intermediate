import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class col4 {
    public static void main(String[] args) {
        
        List<Integer> list =Collections.synchronizedList(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        System.out.println(list);
    }
}
