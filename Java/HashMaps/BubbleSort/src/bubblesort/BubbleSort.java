/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblesort;

/**
 *
 * @author ocamarena
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    void bubleSort(int arr[]){
        int n = arr.length;
        for(int i = 0; i< n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
                
            }
        }
        
    }
    
    void printArr (int arr[]){
        for (int i = 0; i< arr.length; i++){
            System.out.println(arr[i]+" ");
            
        }
        System.out.println();
        
    }
    public static void main(String[] args) {
        // TODO code application logic
        int arr [] = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort bubs = new BubbleSort();
        bubs.printArr(arr);
        bubs.bubleSort(arr);
        bubs.printArr(arr);
        
        
    }
    
}
