import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        // Given lists
        List<Integer> listOne = Arrays.asList( 1, 2, 3, 5, 7, 8, 9, 14);
        List<Integer> listTwo = Arrays.asList(0, 2, 3, 4, 7, 8, 12, 13, 16, 18);
        
        // Get the merged list and print it
        List<Integer> mergedList = mergeLists(listOne, listTwo);

        System.out.println(mergedList);

    }

    /**
     * Utility method to merge two lists.
     * @param listOne
     * @param listTwo
     * @return
     */
    public static List<Integer> mergeLists(List<Integer> listOne, List<Integer> listTwo) {

        // Merged List
        List<Integer> mergedList = new ArrayList<>();

        int i = 0; // index for listOne
        int j = 0; // index for listTwo

        // Iterating over the lists until one of them is exhausted (can be of different size)
        while(i < listOne.size() && j < listTwo.size()) {
            if(listOne.get(i) <= listTwo.get(j)) {
                mergedList.add(listOne.get(i));
                i++;
            } else {
                mergedList.add(listTwo.get(j));
                j++;
            }
        }
        
        // Handle the remaining elements (if any)
        while(i < listOne.size()) {
            mergedList.add(listOne.get(i));
            i++;
        }

        while(j < listTwo.size()) {
            mergedList.add(listTwo.get(j));
            j++;
        }

        return mergedList;
    }
}