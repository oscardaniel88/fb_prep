/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stocks;

/**
 *
 * @author ocamarena
 */
public class Stocks {

    /**
     * @param args the command line arguments
     */
    
    public static int maxProfit(int[]prices){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i <prices.length; i++){
            if(prices[i]<min){
                min = prices[i];
            }else{
                max = Math.max(max,prices[i]-min);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[] stocks = {7,1,5,3,6,4};
        int result = maxProfit(stocks);
        System.out.println("MAX PROFIT = "+result);
        
                
    }
    
}
