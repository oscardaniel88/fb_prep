/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mergesort;

/**
 *
 * @author ocamarena
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    
    public static int [] getSubArray(int[] array, int start,int end){
        int[]result = new int[end-start];
        int k = 0;
        for(int i = start; i<end; i++){
            result[k]=array[i];
            k++;
        }
        return result;
    }
    public static void mergeSort(int[] array){
        if(array.length <=1){
            return;
        }
        int [] left = getSubArray(array,0,array.length/2);
        int [] right = getSubArray(array,array.length/2,array.length);
        mergeSort(left);
        mergeSort(right);
        int i1 = 0;//left iterartor
        int i2 = 0;//right iterator
        for(int i = 0; i<array.length; i++){
            if(i2>=right.length ||(i1<left.length && left[i1]<right[i2])){
                array[i]=left[i1];
                i1++;
            }else{
                array[i]=right[i2];
                i2++;
            }
        }
        return;
    }
    public static void printArray(int[] array){
        for(int i = 0;i<array.length; i++){
            System.out.print(array[i]+"  ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        mergeSort(array);
        printArray(array);
                
    }
    
}
