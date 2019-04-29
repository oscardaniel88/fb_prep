/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fibonaccirecursive;

/**
 *
 * @author ocamarena
 */
public class FibonacciRecursive {

    /**
     * @param args the command line arguments
     */
    
    public static int FiboR(int N){
        if(N==1 || N==2 ){
            return 1;
        }
        return FiboR(N-1) + FiboR(N-2);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int fibo= 0;
        fibo = FiboR(7);
        System.out.print(fibo);
    }
    
}
