/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rolldicessumless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class RollDicesSumLess {

    /**
     * @param args the command line arguments
     */
    public static void RollDicesSumLessHelper(int n, int wanted, List<Integer> combs, int sum,List<List<Integer>> result){
        if(n ==0){
            if(sum == wanted){
                //System.out.println("Combinations = "+Arrays.asList(result)+" sum = "+ sum);
                result.add(new ArrayList<>(combs));
            }
                
        }
        for(int i = 1; i <= 6 ; i++){
            if(sum + i<= wanted){
                sum = sum +i;
                combs.add(i);
                RollDicesSumLessHelper(n-1,wanted,combs,sum,result);
                sum = sum -i;
                combs.remove(combs.size()-1);
            }
        }
    }
    public static void RollDicesSumLess(int n, int wanted){
        if(n>0 && wanted > 0){
            List<Integer> combs = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            RollDicesSumLessHelper(n,wanted,combs,0,result);
            System.out.println(Arrays.asList(result));
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 2;
        int wanted = 6;
        RollDicesSumLess(n, wanted);
    }
    
}
