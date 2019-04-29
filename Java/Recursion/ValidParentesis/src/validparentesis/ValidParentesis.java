/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validparentesis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class ValidParentesis {

    /**
     * @param args the command line arguments
     */
    public static void validPar_helper(List result, String curr,int open,int close, int n){
        if(curr.length() == n*2){
            result.add(curr);
        }
        if(open<n){
            validPar_helper(result,curr+"(",open +1, close, n);
        }
        if(close<open){
            validPar_helper(result,curr+")",open,close+1,n);
        }
    }
    
    public static List<String> validPar(int n){
        List result = new ArrayList();
        validPar_helper(result, "",0,0,n);
        return result;
    }
 
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 10;
        List result = new ArrayList();
        result = validPar(n);
        System.out.println(Arrays.asList(result));
    }
    
}
