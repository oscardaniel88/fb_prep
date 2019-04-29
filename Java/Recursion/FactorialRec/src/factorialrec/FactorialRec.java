/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factorialrec;

/**
 *
 * @author ocamarena
 */
public class FactorialRec {

    /**
     * @param args the command line arguments
     */
    public static int fact(int n){
       int result;
       if(n==0 || n==1)
         return 1;

       result = fact(n-1) * n;
       return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 0;
        n = fact(4);
        System.out.println(n);
    }
    
}
