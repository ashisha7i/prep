import java.util.Arrays;

public class StringPrep {
    public static void main(String[] args) {
        String str = "This is a string";

        System.out.println(str);

        // String to character array
        char[] chars = str.toCharArray();

        System.out.println(Arrays.toString(chars));

        // Convert case
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        
        // Concat
        System.out.println(str.concat("ABC"));

        // Split: Split a string with a 'regex'
        String[] arr = str.split(" ");
        System.out.println(Arrays.toString(arr));

        // Join: with a delimiter
        System.out.println(String.join(",", arr));

        // charAt
        System.out.println("India".contains("ia"));

        System.out.println(String.format("The name is %s he is %d years old", "Ajay", 32));

        System.out.println(String.valueOf(true));

        System.out.println("ABCDEFG".substring(1, 4));

        System.out.println(str);
    }
}
