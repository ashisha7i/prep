import java.util.HashMap;
import java.util.Map;

// PROBLEM: Given a sentence, find most repeated word
public class Problem15 {
    
    public static void main(String[] args) {
        Problem15 problem = new Problem15();
        problem.solve();
    }

    private void solve() {
        String testStr = "java is a programming language. java is a platform. java is an Island. java is a drink too.";
        System.out.println("Original String: " + testStr);
        System.out.println("Most repeated word in the string: " + mostRepeatedWord(testStr));
    }

    private String mostRepeatedWord(String testStr) {
        String[] words = testStr.split(" ");
        Map<String, Integer> wordMap = new HashMap<>();
        
        // Find the count of each word in the string
        for(String word: words) {
            wordMap.putIfAbsent(word, 0); // initialize count to 0 (if not already present)
            wordMap.put(word, wordMap.get(word) + 1);
        }

        // Find the word with maximum count
        int maxCount = 0;
        String maxCountWord = "";
        for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxCountWord = entry.getKey();
            }
        }
        System.out.printf("Word '%s' is the most repeated word. Repeated %d times.\n", maxCountWord, maxCount);
        return maxCountWord;
    }

}
