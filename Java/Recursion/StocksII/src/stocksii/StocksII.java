/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stocksii;

/**
 *
 * @author ocamarena
 */
public class StocksII {

    /**
     * @param args the command line arguments
     */
    public static int maxProfit(int[]prices){
        int profit = 0;
        for(int i = 0; i+1<prices.length; i++){
            if(prices[i+1]>prices[i]){
                profit += prices[i+1]-prices[i];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[]stocks = {1,2,3,4,5};
        int result = maxProfit(stocks);
        System.out.println("MAX PROFIT = "+result);
        
    }
    
}
