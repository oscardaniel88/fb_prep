/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pow;

/**
 *
 * @author lucky
 */
public class Pow {
    
    public static int power(int n, int pow){
        if(pow==0){
            return 1;
        }else{
            return n * power(n, pow-1);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 2;
        int pow = 20;
        int result = power(n, pow);
        System.out.println(result);
    }
    
}
