// Problem 11. Reverse Words in a String

public class Solution11 {
    
    public static void main(String[] args) {
        String strToReverse = "This is a test string";
        
        System.out.println("Original String: " + strToReverse);
        System.out.println("Reversed String: " + reverseWords(strToReverse));
    }

    /**
     * Utility method to reverse words in a string
     * @param testString
     * @return
     */
    public static String reverseWords(String testString) {
        String[] wordsArr = testString.split(" ");
        String[] reversedArr = new String[wordsArr.length];

        for(int i = wordsArr.length - 1, j=0; i >= 0; i--, j++) {
            reversedArr[j] = wordsArr[i];
        }

        return String.join(" ", reversedArr);
    }

}
