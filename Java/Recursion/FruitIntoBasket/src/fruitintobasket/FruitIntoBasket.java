/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fruitintobasket;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class FruitIntoBasket {

    /**
     * @param args the command line arguments
     */
    public static int getBasketType(List<Integer> basket){
        if(basket.size()==0)
            return -1;
        return basket.get(0);
    }
    
    public static int totalFruit(int[]tree){
        List<Integer> fruit1 = new ArrayList<>();
        List<Integer> fruit2 = new ArrayList<>();
        int max = 0;
        for(int j = 0; j<tree.length; j++){
            
            for(int i = j; i<tree.length; i++){
                if(fruit1.isEmpty()&&tree[i]!=getBasketType(fruit2)){
                    fruit1.add(tree[i]);
                }else if(fruit2.isEmpty()&&tree[i]!=getBasketType(fruit1)){
                    fruit2.add(tree[i]);
                }else if(tree[i]==getBasketType(fruit1)){
                    fruit1.add(tree[i]);
                }else if(tree[i]==getBasketType(fruit2)){
                    fruit2.add(tree[i]);
                }else{
                    break;
                }
                if(fruit1.size()+fruit2.size()>max)
                    max = fruit1.size()+fruit2.size();
            }
            fruit1.clear();
            fruit2.clear();
        }
        return max;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int [] trees = {0,0,1,1};
        int result = totalFruit(trees);
        System.out.println("result  " + result);
        
    }
    
}
