import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.

    static long getMax(int[] array){
        long max = -999;
        for(int i = 0; i<array.length;i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        return max;
    }
    static long arrayManipulation(int n, int[][] queries) {
        int numRows = queries.length;
        int [] array = new int[n+1];
        for (int i = 0; i < array.length; i ++){
            array[i]=0;
        }
        int j = 0;
        while(j < numRows){
            int start = queries[j][0];
            int end = queries[j][1];
            int oper = queries[j][2];
            while(start < end+1){
                array[start]=array[start]+oper;
                start += 1;
            }
            j += 1;
        }     

        return getMax(array) ;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(String.valueOf(result));
       

        scanner.close();
    }
}
