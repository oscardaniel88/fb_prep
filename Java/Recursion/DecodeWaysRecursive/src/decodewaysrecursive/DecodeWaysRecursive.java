/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decodewaysrecursive;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class DecodeWaysRecursive {

    /**
     * @param args the command line arguments
     */
    public static void recursive(String s, List<Integer> result){
        if(s.length() == 0){
            result.add(1);
        }else{
            int value = s.charAt(0)-'0';
            if(value>0 && value <=9)
                recursive(s.substring(1),result);
            if(s.length()>=2){
              int value1 = s.charAt(0)-'0';
              int value2 = s.charAt(1)-'0';
              int value3 = value1*10 + value2;
              if(value3>=10 && value3<=26)
                  recursive(s.substring(2),result);
            }
        }
        
        
    }
    public static int decodeWays(String s){
        List<Integer> result = new ArrayList<>();
        if(s.length()!=0)
            recursive(s,result);
        return result.size();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String input = "1234232425";
        int result = decodeWays(input);
        System.out.println("Decode ways " + result);
    }
    
}
