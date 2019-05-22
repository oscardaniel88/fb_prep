/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package combinationsum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class CombinationSum2 {

    /**
     * @param args the command line arguments
     */
    public static void helper(int[] candidates, int target,List<List<Integer>> result,int start, List<Integer> curr){
        if(target==0){
            if(!result.contains(curr)){
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int i = start; i<candidates.length; i++){
            curr.add(candidates[i]);
            helper(candidates,target-candidates[i],result,i+1,curr);
            curr.remove(curr.size()-1);
        }
    }
    
    public static List<List<Integer>> combinationSum2(int[]candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates.length == 0)
            return result;
        helper(candidates,target,result,0,curr);
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 10;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }
    
}
