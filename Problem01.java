import java.util.HashMap;
import java.util.Map;

//PROBLEM: Given an array of integers, find two numbers such that they add up to a specific target number
public class Problem01 {
    public static void main(String[] args) {
        Problem01 problem = new Problem01();
        problem.solve();
    }

    private void solve() {
        // Given
        int[] givenArr = {1, 7, 8, 3, 5, 4, 2 };
        int target = 13;

        // Solution
        Map <Integer, Integer> indexMap = new HashMap<>();
        // Put values in the map key = number, value = index
        for(int i=0; i<givenArr.length; i++) {
            indexMap.put(givenArr[i], i);
        }

        // Traversing the map and check if the complement exists for any
        for(Integer num: indexMap.keySet()) {
            int diff = target - num;
            if(indexMap.containsKey(diff)){
                System.out.println("Answer : [" + indexMap.get(diff) + ", " + indexMap.get(num) + "]" );
                break;
            }
        }
    }
}