/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package houserobber;

/**
 *
 * @author ocamarena
 */
public class HouseRobber {

    /**
     * @param args the command line arguments
     */
    public static int houseRobber(int[] input){
        if(input.length == 0)
            return 0;
        if(input.length == 1)
            return input[0];
        if(input.length == 2){
            return Math.max(input[0],input[1]);
        }
        int [] dp = new int[input.length];
        dp[0]=input[0];
        dp[1]=Math.max(input[0],input[1]);
        for(int i = 2; i<input.length; i++){
            dp[i]=Math.max(dp[i-2] + input[i], dp[i-1]);
        }
        return dp[input.length-1];
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int [] input = {1,2,3,1};
        int output = houseRobber(input);
        System.out.println("Max robber profit "+ output);
    }
    
}
