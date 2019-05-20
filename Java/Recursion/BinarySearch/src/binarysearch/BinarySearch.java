/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarysearch;

/**
 *
 * @author ocamarena
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    
    public static int binarySearch(int[]array,int value,int start, int end){
        int mid = (end+start)/2;
        if(value == array[mid]){
            return mid;
        }else if(value < array[mid]&&start<end){
            //search on the bottom part of the array i.e from 0 to mid -1;
            return binarySearch(array,value,start,mid-1);
        }else if(value>array[mid]&&start<end){
            //search on the top part of the array i.e. from mid + 1 to end;
            
            return binarySearch(array, value, mid +1, end);
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] array = {3,4,5,7,10,11,21,23,33,44,56,78,99};
        int value = 23;
        int index = binarySearch(array,value,0,array.length-1);
        if(index != -1)
            System.out.println("Value  " + value +" located in index " + index + "  A[index]= "+array[index]);
        else
            System.out.println("Value not found on array");
        
                 
        // TODO code application logic here
    }
    
}
