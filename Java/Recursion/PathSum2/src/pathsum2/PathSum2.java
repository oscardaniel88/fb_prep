/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pathsum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ocamarena
 */

public class PathSum2 {

    /**
     * @param args the command line arguments
     */
    public static void print(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.data);
        print(root.left);
        print(root.right);
                    
    }
    
    
    public static void pathSumHelper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> curr){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && sum-root.data == 0){
            curr.add(root.data);
            result.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
        }
        if(root.left == null && root.right == null && sum-root.data != 0)
            return;
        curr.add(root.data);
        pathSumHelper(root.left, sum-root.data, result,curr);
        pathSumHelper(root.right, sum-root.data, result,curr);
        curr.remove(curr.size()-1);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<Integer> current = new ArrayList<>();
        pathSumHelper(root,sum,result,current);
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.right = null;
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);
        //print(node);
        int sum = 18;
        List<List<Integer>> result = pathSum(node,sum);
        System.out.println(Arrays.asList(result));
        
        
    }


    
    
}
