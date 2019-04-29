/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rolldices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class RollDices {

    /**
     * @param args the command line arguments
     */
    
    public static void rollDicesHelper(int dices, List<Integer> result){
        if(dices == 0){
            System.out.println(Arrays.asList(result));
        }else{
            for(int i = 1; i<=6; i++){
                result.add(i);
                rollDicesHelper(dices-1,result);
                result.remove(result.size()-1);
            }
        }
    }
    public static void rollDices(int dices){
        if(dices >0){
            List<Integer> result = new ArrayList<>();
            rollDicesHelper(dices,result);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int dices = 4;
        rollDices(dices);
    }
    
}
