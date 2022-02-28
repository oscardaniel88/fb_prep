/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author lucky
 */
public class MergeSort {
    
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
 
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            a[k++] = l[i++];
        }
        else {
            a[k++] = r[j++];
        }
    }
    while (i < left) {
        a[k++] = l[i++];
    }
    while (j < right) {
        a[k++] = r[j++];
    }
}
    
    public static void mergeSort(int[] array, int n){
        if (n < 2){
            return;
        }
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        // populate left
        for(int i = 0; i < mid; i++){
            left[i] = array[i];
        }
        // populate right
        for(int j = mid; j < n; j++){
            right[j-mid] = array[j];
        }
        //dividing and conquering
        mergeSort(left, mid);
        mergeSort(right, n-mid);
        merge(array, left, right, left.length, right.length);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = new int[]{54,98,76,87,101,2,5,8,12,24};
        mergeSort(array, array.length);
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    
}
