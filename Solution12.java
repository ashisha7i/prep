//PROBLEM: Given a string, find most repeated character
public class Solution12 {
    public static void main(String[] args) {
        String testString = "abracadabra";

        System.out.println(" Original String: " + testString);
        System.out.println(" Most repeated character: " + getMostFrequentCharacter(testString));

    }

    public static Character getMostFrequentCharacter(String testStr) {
        int[] charCount = new int[256];
        int maxCount = 0;
        Character maxChar = null;

        for(Character c: testStr.toCharArray()) {
            charCount[c]++;
            if(charCount[c] > maxCount) {
                maxCount = charCount[c];
                maxChar = c;
            }
        }

        return maxChar;
    }
}
