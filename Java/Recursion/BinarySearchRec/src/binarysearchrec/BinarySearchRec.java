/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchrec;
import java.util.Random;

/**
 *
 * @author lucky
 */
public class BinarySearchRec {
    
    
    public static int binarySearchHelper(int[] array, int key, int min, int max){
        if(max<min){
            return -1;
        }
        int mid = (min + max)/2;
        if(key < array[mid]){
           return binarySearchHelper(array, key, min, mid - 1);
        }else if (key > array[mid]){
            return binarySearchHelper(array, key, mid + 1, max);
        }
        return mid;
    }
    
    public static int binarySearch(int[] array, int key){
        return binarySearchHelper(array, key, 0, array.length -1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int max = 100000;
        Random rand = new Random();
        int key = rand.nextInt(max);
        int[] array = new int [max];
        for (int i = 0; i < max; i++){
            array[i]= i;
        }
        int index = binarySearch(array, key);
        if(index == -1){
            System.out.println("Key not found");
        }else{
            System.out.println("Key " + key + " is located in index " + index + " Validating array[index] == " + array[index]);
        }
    }
    
}
