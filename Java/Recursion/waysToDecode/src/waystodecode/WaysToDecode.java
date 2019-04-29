/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package waystodecode;

/**
 *
 * @author ocamarena
 */
public class WaysToDecode {

    /**
     * @param args the command line arguments
     * 
     *    public int numDecodings(String s) {
       int n = s.length();
        int[] fn = new int[n+1];
        fn[0] = 1;
        fn[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != '0')
                fn[i+1] = fn[i];
            int v = Integer.parseInt(s.substring(i-1, i+1));
            if (v >= 10 && v <= 26)
                fn[i+1] += fn[i-1];
        }
        return fn[n];
    }
     */
    
    public static int waysToDecode(String s){
        int n = s.length();
        int[] dp = new int [n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)!='0'? 1:0;
        for (int i = 1; i < n; i++){
            if(s.charAt(i)!='0')
                dp[i+1]=dp[i];
            int val = Integer.parseInt(s.substring(i-1,i+1));
            if(val >= 10 && val <= 26)
                dp[i+1]+=dp[i-1];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        String message = "226";
        int result = 0;
        result = waysToDecode(message);
        System.out.println(result);
    }
    
}
