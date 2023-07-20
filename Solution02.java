import java.util.Stack;

public class Solution02 {
    public static void main(String[] args) {
        // Problem : Check if a string has balanced brackets
        // Given
        String testString = "[()]{}{[()()]()}"; // balanced

        System.out.printf("%nString \"%s\" is %s%n", testString, areBracketsBalanced(testString)?"Balanced":"Not Balanced");
    }

    /**
     * Utility method to check if a string has balanced brackets
     * @param testString
     * @return
     */
    private static boolean areBracketsBalanced(String testString) {
        Stack<Character> stack = new Stack<>();

        // Getting the characters one by one
        for(Character c: testString.toCharArray()) {
            
            // If opening bracket, push to stack
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            // 👉 What if there are no opening brackets??
            if(stack.isEmpty()) {
                return false;
            }

            char temp;
            
            // If closing bracket, pop from stack and check if it matches
            switch(c) {
                case ')':
                    temp = stack.pop();
                    if(temp != '(') {
                        return false;
                    }
                    break;
                case '}':
                    temp = stack.pop();
                    if(temp != '{') {
                        return false;
                    }
                    break;
                case ']':
                    temp = stack.pop();
                    if(temp != '[') {
                        return false;
                    }
                    break;
            }
        }

        // Stack should be empty if all brackets were balanced
        return stack.isEmpty(); 
    }
}
