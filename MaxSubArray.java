

public class MaxSubArray {
    // PROBLEM: Describe the problem you are trying to solve



    public static void main(String[] args) {
        MaxSubArray problem = new MaxSubArray();
        int[][] numsArr = {
            { -3, 1, -8, 4, -1, 3, 4, 5, -10, 8, 4, 13, 2, 6, 4 },
            { -3, 1, 6, 4 },
            { -1, 2, 2, -5, -10, 8, 4, 13, 2, 6, 4 },
            { 3, 4, 5, -10, 8, 13, 2, 6, 4 },
            { -8, 4, 2, -5, 3, 4, 5, -10, 8, 4, 13, 2, 6, 4 },
            { -3, 1, -8, 4, -1, 4, 13, 4 },
            { -3, 1, -8, 4, -1, 2, 4, 13, 2, 6, 4 },
            { -3, 1, -8, 4, -1, 2, 6, 4 }
        };
        
        for(int[] nums: numsArr) {
            System.out.println("Array: " + java.util.Arrays.toString(nums));
            problem.solveBruteForce(nums);
            problem.solveUsingKadanesAlgorithm(nums);
            System.out.println(" ");
        }
    }

    public void solveBruteForce(int[] nums) {
        int counter = 0;
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int left = 0; left < len; left++) {
            int runningSum = 0;

            for (int right = left; right < len; right++) {
                runningSum += nums[right];

                if (runningSum > maxSum) {
                    maxSum = runningSum;
                    start = left;
                    end = right;
                }
                counter++;
            }
        }

        System.out.println("S1: Found Maximum Sum " + maxSum + " for subarray between " + start  + " and " + end + " / Array size:  " + len + " / Iterations: " + counter );
    }

    public void solveUsingKadanesAlgorithm(int[] arr) {
        int counter = 0;
        int size = arr.length;
        int start = 0;
        int end = 0;

        int maxSoFar = arr[0], maxEndingHere = arr[0];

        for (int i = 1; i < size; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                start = i;
                maxEndingHere = arr[i];
            } else
                maxEndingHere = maxEndingHere + arr[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                end = i;
            }
            counter++;
        }
        System.out.println("S2: Found Maximum Sum " + maxSoFar + " for subarray between " + Math.min(start, end) + " and " + end + " / Array size:  " + size + " / Iterations: " + counter );
    }
}