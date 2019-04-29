/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package permutes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class Permutes {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0) return result;
        permutations(nums,result,0);
        return result;
        
    }
    
    public static void permutations(int[]nums,List<List<Integer>> result, int start){
        if(start>=nums.length){
            List<Integer> permutes = new ArrayList<>();
            for(int i = 0; i<nums.length;i++){
                permutes.add(nums[i]);
            }
            result.add(permutes);
            return;
        }
        for(int i = start; i<nums.length; i++){
            swap(nums,i,start);
            permutations(nums,result,start+1);
            swap(nums,i,start);
        }
    }
    
    public static void swap(int[]nums,int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(Arrays.asList(result));
        // TODO code application logic here
    }
    
}
