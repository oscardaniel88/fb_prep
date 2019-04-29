/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursive1ton;

/**
 *
 * @author ocamarena
 */
public class Recursive1toN {

    public static void printN(int N, int current){
        if (current <= N){
            System.out.println(current);
            printN(N,current+1);
        }
        
    }
    public static void main(String[] args) {
        printN(10,0);
    }
    
}
