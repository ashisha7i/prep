import java.util.Arrays;


// PROBLEM: Given an array of integers, move all zeros to the end of the array.
public class Problem17 {
    public static void main(String[] args) {
        Problem17 problem = new Problem17();
        problem.solve();
    }

    private void solve() {
        int[] testArr = {1, 2, 0, 4, 3, 0, 5, 0, 6, 0, 7, 8, 9, 0};

        System.out.println("Original Array: " + Arrays.toString(testArr));
        System.out.println("Array with zeros moved to the end: " + Arrays.toString(new Problem17().moveZerosToEndWithExtraArray(testArr)));

        System.out.println("Calling in place rearrange method");
        moveZeroesToEndInPlace(testArr);
        System.out.println("Array after moving zeroes to right");
        System.out.println(Arrays.toString(testArr));
    }
    
    /**
     * Utility method to move all zeros to the end of the array
     * @param numArr
     * @return
     */
    private int[] moveZerosToEndWithExtraArray(int[] numArr) {
        int[] resultArr = new int[numArr.length]; // default value of int is 0
        int arrIndex = 0; // index for result array (start from the first element)

        // Copy all non-zero elements to result array starting from index 0
        for(int i = 0; i < numArr.length; i++) {
            if(numArr[i] != 0) {
                resultArr[arrIndex++] = numArr[i];
            }
        }

        // Remaining elements in result array are zeros
        return resultArr;
    }

    /**
     * Method to move the zeroes in array to the end.
     * NOTE :: THIS WILL CHANGE THE ARRAY (hence the 'void' return type)
     * @param numArr
     */
    private void moveZeroesToEndInPlace(int[] numArr) {
        // Logic, iterate over the elements of array, if current element is zero - swap it with the next element
        for(int i=0; i < numArr.length - 1; i++) { // Note: we are iterating to the penultimate item (length -1)
            int currNum = numArr[i];
            if(currNum == 0) {
                // Leaving this logic here - as it looks okay but will produce incorrect results when two consecutive zeroes occur in array
                // int temp = numArr[i+1];
                // numArr[i] = temp;
                // numArr[i+1] = currNum; // OR numArr[i+1] = 0; since currNum is guranteed to be zero here
                swapWithNextNonZeroElement(numArr, i);
            }
        }
    }
    
    private void swapWithNextNonZeroElement(int[] numArr, int currIndex) {
        // Find the next 'non-zero' element
        for(int i = currIndex; i < numArr.length - 1; i++) {
            int temp = numArr[i];
            if(temp != 0) {
                numArr[currIndex] = temp;
                numArr[i] = 0;
                break; // No need to continue the loop as our work here is done
            }
        }
    }
}
