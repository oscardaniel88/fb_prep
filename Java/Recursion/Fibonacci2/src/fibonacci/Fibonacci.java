/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lucky
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    
    public static int fibonacci(int n, int [] cache){
        if(n == 0 || n == 1){
            return n;
        }else{
            if(cache[n]!= 0){
                return cache[n];
            }
            int resp = fibonacci(n-1, cache) + fibonacci(n-2, cache);
            cache[n] = resp;
            return resp;
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> sequence = new ArrayList<>();
        int [] cache = new int[10000];
        int n = 1000;
        for (int i =0 ; i < n ; i++){
            sequence.add(fibonacci(i, cache));
        }
        System.out.println(sequence);
    }
    
}
