import java.util.HashMap;
import java.util.Map;

// PROBLEM:  Given a string, find number of times each character is repeated in the string
public class Problem13 {
    public static void main(String[] args) {
        Problem13 problem = new Problem13();
        problem.solve();
    }

    private void solve() {
        String testStr = "A simple test string";
        Map<Character, Integer> charMap = findRepeatedCharacters(testStr, true);

        System.out.println("Original String: " + testStr);
        System.out.println("Repeated characters in the string: ");
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    /**
     * Utility method to find repeated characters in a string
     * @param testStr
     * @param ignoreSpaces
     * @return
     */
    private static Map<Character, Integer> findRepeatedCharacters(String testStr, boolean ignoreSpaces) {
        char[] charArr = testStr.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        for(char c : charArr) {
            if(ignoreSpaces && c == ' ') {
                continue;
            }

            if(charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        return charMap;
    }
}
