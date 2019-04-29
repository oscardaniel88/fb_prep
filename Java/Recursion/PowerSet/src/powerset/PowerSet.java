/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package powerset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class PowerSet {

    /**
     * @param args the command line arguments
     */
    public static void powerSetHelper(List<Integer> set, List<Integer>chosen){
        if(set.size()==0){
            System.out.println(Arrays.asList(chosen));
        }else{
            int i = set.get(0);
            set.remove(0);
            chosen.add(i);
            powerSetHelper(set,chosen);
            chosen.remove(chosen.size()-1);
            powerSetHelper(set,chosen);
            set.add(i);
        }
        
        
    }
    
    public static void powerSet(List<Integer> set){
        List<Integer> chosen = new ArrayList<>();
        if(set.size()>0);
            powerSetHelper(set,chosen);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        powerSet(set);
    }
    
}
