/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printarrayelementsrecursive;

/**
 *
 * @author lucky
 */
public class PrintArrayElementsRecursive {
    
    public static void printArrayElementsRecursive(int[] array, int idx){
        if(idx >= array.length){
            return;
        }else{
            System.out.println(array[idx]);
            printArrayElementsRecursive(array, idx +1);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] array = new int[]{1,2,3,4,5};
        printArrayElementsRecursive(array,0);
    }
    
}
