/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lucky
 */
public class Permutations2 {

    /**
     * @param args the command line arguments
     */
    public static void helper (String prefix, String suffix, List<String> result){
        if(prefix.length() == 0){
            result.add(suffix);
            return;
        }
        for(int i = 0; i < prefix.length(); i++){
            helper(prefix.substring(0, i)+ prefix.substring(i+1), suffix+prefix.charAt(i), result);
        }
    }
    public static List<String> permutations(String input){
        List<String> result = new ArrayList<>();
        helper(input,"",result);
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String input = "ABC";
        List<String> result = new ArrayList <> ();
        result = permutations(input);
        System.out.println(Arrays.asList(result));   
    }
    
}
