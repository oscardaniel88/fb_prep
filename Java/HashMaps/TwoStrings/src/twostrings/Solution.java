import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.HashMap; 


public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        Map<String, List<String>> words = new HashMap<>();
        String resp = "NO";
        for (int i = 0; i< s1.length(); i++){
            if(words.get(Character.toString(s1.charAt(i)))==null){
                List<String> list = new ArrayList<>();
                words.put(Character.toString(s1.charAt(i)), list);
                words.get(Character.toString(s1.charAt(i))).add(s1);
            }

        }
        for (int i = 0; i< s2.length(); i++){
            if(words.get(Character.toString(s2.charAt(i)))!=null){
                words.get(Character.toString(s2.charAt(i))).add(s2);
                resp = "YES";
            }
                
        }
        return resp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }



        scanner.close();
    }
}
