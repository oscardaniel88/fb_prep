/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringpermute;

/**
 *
 * @author ocamarena
 */
public class StringPermute {

    /**
     * @param args the command line arguments
     */
    public static void permuteHelper(String s, String chosen){
        if(s.length() == 0){
            System.out.println(chosen);
        }else{
            for(int i = 0; i<s.length(); i++){
                Character c = s.charAt(i);
                chosen = chosen + c;
                s = s.substring(0,i)+s.substring(i+1,s.length());
                permuteHelper(s,chosen);
                s = s.substring(0,i)+c+s.substring(i,s.length());
                chosen = chosen.substring(0,chosen.length()-1);
            }
        }
    }
    public static void permute(String s){
        permuteHelper(s,"");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "ISRAEL";
        permute(s);
    }
    
}
