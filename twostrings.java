import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
    // Write your code here
        // int i = 0;
        // while (i < s1.length()) {
        //     int j = 0;
        //     while (j < s2.length()) {
        //         if (s1.charAt(i) == s2.charAt(j)) return "YES";
        //         j++;
        //     }
        //     i++;
        // }
        // return "NO";
        
        if (twoStringsRecurse(s1, s2, 0 ,0)) return "YES";
        return "NO";
    }
    
    static boolean twoStringsRecurse(String s1, String s2, int i, int j) {
        if (s1.length() == i) return false;
        if (s2.length() == j) return twoStringsRecurse(s1, s2, i+1, 0);
        if (s1.charAt(i) == s2.charAt(j)) return true;
        else return twoStringsRecurse(s1, s2, i, j+1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
