/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lettercombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ocamarena
 */
public class LetterCombinations {
    private static Map<Character,String> letters = new HashMap<Character,String>();
    
    public static void fillLetters(){
        letters.put('2',"abc");
        letters.put('3',"def");
        letters.put('4',"ghi");
        letters.put('5',"jkl");
        letters.put('6',"mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9',"wxyz");
    }
    

    /**
     * @param args the command line arguments
     */
    public static void helper_combinations(String digits, List<String>result, int index, String prefix){
        if(index == digits.length()){
            result.add(prefix);
            return;
        }
        String combin = letters.get(digits.charAt(index));
        for(int i = 0; i < combin.length(); i ++){
            helper_combinations(digits,result,index+1,prefix + combin.charAt(i));
        }
    
        
    }
    public static List<String> combinations(String digits){
        List<String> result =new  ArrayList();
        helper_combinations(digits,result,0,"");
        return result; 
        
    }
    
    

    public static void main(String[] args) {
        String digits = "23";
        fillLetters();
        List<String> result =new  ArrayList();
        result = combinations(digits);
        System.out.println(Arrays.asList(result));
        // TODO code application logic here
    }
    
}
