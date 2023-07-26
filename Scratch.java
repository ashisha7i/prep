import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scratch {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<=100;i++) {
            numbers.add(i);
        }

        // Delete all elements at even index positions
        // for(int i=0; i<numbers.size(); i++) {
        //     if (i % 2 == 0) {
        //         numbers.remove(i);
        //     }
        // }
        
        int i = 0;
        Iterator<Integer> listItr = numbers.iterator();
        while(listItr.hasNext()) {
            Integer temp = listItr.next();
            if(i % 2 == 0) {
                listItr.remove();
            }
            i++;
        }

        System.out.println(numbers);
    }
}

