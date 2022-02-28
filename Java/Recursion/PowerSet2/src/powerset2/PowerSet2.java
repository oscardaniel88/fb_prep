/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerset2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucky
 */
public class PowerSet2 {
    
    public static void powerSetHelper(List<Integer> set, List<Integer> chosen, int idx){
        if(idx>= set.size()){
            System.out.println(chosen);
            return;
        }else{
            powerSetHelper(set, chosen, idx + 1);
            chosen.add(set.get(idx));
            powerSetHelper(set, chosen, idx + 1);
            chosen.remove(chosen.size()-1);
        }
    }
    
    public static void powerSet(List<Integer> set){
        List<Integer> chosen = new ArrayList<>();
        if(set.size()>0);
            powerSetHelper(set,chosen, 0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        powerSet(set);
    }
    
}
