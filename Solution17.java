//Problem 17. - [ ] Moving all the zeros to the end of the array

import java.util.Arrays;

public class Solution17 {
    public static void main(String[] args) {
        int[] testArr = {1, 2, 0, 4, 3, 0, 5, 0, 6, 0, 7, 8, 9, 0};

        System.out.println("Original Array: " + Arrays.toString(testArr));
        System.out.println("Array with zeros moved to the end: " + Arrays.toString(new Solution17().moveZerosToEnd(testArr)));
    }

    /**
     * Utility method to move all zeros to the end of the array
     * @param testArr
     * @return
     */
    private int[] moveZerosToEnd(int[] testArr) {
        int[] resultArr = new int[testArr.length]; // default value of int is 0
        int arrIndex = 0; // index for result array (start from the first element)

        // Copy all non-zero elements to result array starting from index 0
        for(int i = 0; i < testArr.length; i++) {
            if(testArr[i] != 0) {
                resultArr[arrIndex++] = testArr[i];
            }
        }

        // Remaining elements in result array are zeros
        return resultArr;
    }
    
}
