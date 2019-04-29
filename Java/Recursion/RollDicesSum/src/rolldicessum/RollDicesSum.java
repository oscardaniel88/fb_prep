/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rolldicessum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class RollDicesSum {

    /**
     * @param args the command line arguments
     */
    public static void rollDicesSumhelper(int dices, List<Integer> result, int sum){
        if(dices == 0){
            System.out.println("Combinations == "+Arrays.asList(result)+ "  sum = "+ sum);
        }else{
            for(int i = 0; i<= 6; i++){
                result.add(i);
                sum = sum +i;
                rollDicesSumhelper(dices-1,result,sum);
                sum = sum -i;
                result.remove(result.size()-1);
            }
        }
    }
    public static void rollDicesSum(int dices){
        if(dices>0){
            List<Integer> result = new ArrayList<>();
            rollDicesSumhelper(dices,result,0);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int dices = 2;
        rollDicesSum(2);
    }
    
}
