/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        if(nums == null || nums.length ==0){
            return result;
        }
        for(int i = 0; i<=nums.length; i++){
            setsRec(nums,i,result,currSet,0);
        }
        return result;
    }
    
    public static void setsRec(int[]nums, int size,List<List<Integer>> result,List<Integer> currSet, int start){
        if(currSet.size() == size){
            result.add(new ArrayList(currSet));
            return;
        }
        for(int i = start; i<nums.length; i++){
            currSet.add(nums[i]);
            setsRec(nums,size,result,currSet,i+1);
            currSet.remove(currSet.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(Arrays.asList(result));
        
        
    }
    
}
