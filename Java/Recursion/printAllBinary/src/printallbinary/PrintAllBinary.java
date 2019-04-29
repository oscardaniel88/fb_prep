/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package printallbinary;

/**
 *
 * @author ocamarena
 */
public class PrintAllBinary {

    /**
     * @param args the command line arguments
     */
    
    public static void printAllBinaryHelper(int n, String binsofar){
        if(n==0){
            System.out.println(binsofar);
        }else{
            printAllBinaryHelper(n-1, binsofar+"0");
            printAllBinaryHelper(n-1, binsofar+"1");
        }
    }
    public static void printAllBinary(int n){
        if(n>0){
            printAllBinaryHelper(n,"");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic 
        int n = 5;
        printAllBinary(n);
    }
    
}
