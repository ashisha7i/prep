import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem14 {
    public static void main(String[] args) {
        Problem14 p14 = new Problem14();
        p14.solve();
    }

    public void solve() {
        String sentence = "this is a simple sentence that we need to check the repetitions in";

        Map<Character, Integer> freqMap = new HashMap<>();
        List<Character> charList = new ArrayList<>(); 
        
        for (char c : sentence.toCharArray()) {
            // Ignore ' '
            if (c == ' ')
                continue;

            if (freqMap.get(c) == null) {
                freqMap.put(c, 0);
                charList.add(c);
            }

            // Get the current value
            int freq = freqMap.get(c);

            // Add freq + 1 to the map
            freqMap.put(c, freq + 1);
        }

        // Print the frequency map
        System.out.println(freqMap);
        System.out.println(charList);

        Collections.sort(charList, new Comparator<Character>() {

            @Override
            public int compare(Character o1, Character o2) {
                return freqMap.get(o1) - freqMap.get(o2);
            }
            
        });
        System.out.println(charList);
    }
}
