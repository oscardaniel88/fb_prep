/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decodeways;

/**
 *
 * @author ocamarena
 */
public class DecodeWays {

    /**
     * @param args the command line arguments
     */
  
    public static int decodeWays(String s){
        int [] dp = new int[s.length() +1];
        dp[0]= 1;
        dp[1]= s.charAt(0) == '0'?0:1;
        for(int i = 2; i<=s.length(); i++){
           int oneDigit =  Integer.valueOf(s.substring(i-1,i));
           int twoDigit = Integer.valueOf(s.substring(i-2,i));
           if(oneDigit >0)
               dp[i] += dp[i-1];
           if(twoDigit >= 10 && twoDigit <= 26){
               dp[i]+=dp[i-2];
           }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        String input = "1234";
        int result = decodeWays(input);
        System.out.println("Decode ways " + result);
        
        // TODO code application logic here
    }
    
}
