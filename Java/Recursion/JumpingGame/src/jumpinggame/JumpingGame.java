/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jumpinggame;

/**
 *
 * @author ocamarena
 */
public class JumpingGame {

    /**
     * @param args the command line arguments
     */
    public static boolean jumpinGame(int n [], int index){
        int maxCell = n[0];
        if(n[0]==0){
            return false;
        }
        if(n[0]>=n.length-1){
            return true;
        }
        for(int i = 1; i <n.length; i++){
            if(i>maxCell||maxCell >= n.length-1)
                break;
            maxCell = Math.max(maxCell,i+n[i]);
        }
        return maxCell >= n.length -1;
    }
    
    public static void main(String[] args) {
        int [] n = {2,0,1,1,4};
        System.out.println(jumpinGame(n,0));
        
        
    }
    
}
