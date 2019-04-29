/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quicksort;

/**
 *
 * @author ocamarena
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    
    public int partition(int array[],int low,int high){
        int border = 0;
        int pivotIndex = (int)(low+high)/2;
        int pivot = array[pivotIndex];
        array[pivotIndex]=array[low];
        array[low]=pivot;
        border = low;
        for(int i = low; i <= high; i++){
            if(array[i]<pivot){
                border += 1;
                int temp = array[i];
                array[i] = array[border];
                array[border]=temp;
            }
        }
        int temp = array[low];
        array[low] = array[border];
        array[border]= temp;
        return border;
    }
    
    public int [] quickSort(int array[],int low, int high){
        if(low>high){
            return array;
        }
        int p;
        p = this.partition(array,low,high);
        return this.quickSort(array,low,p-1),quickSort(array,p+1,high)
        return this.quickSort(array,p+1,high);
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
