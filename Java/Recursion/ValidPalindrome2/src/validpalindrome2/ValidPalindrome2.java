/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validpalindrome2;

/**
 *
 * @author ocamarena
 */
public class ValidPalindrome2 {

    /**
     * @param args the command line arguments
     */
    public static boolean isPalindrome(String s){
        StringBuilder reverse = new StringBuilder();
        for(int i = s.length()-1 ; i>= 0; i--){
            reverse.append(s.charAt(i));
        }
        return reverse.toString().equals(s);
    }
    public static boolean validPalindrome(String s, boolean flag) {
        if(isPalindrome(s))
            return true;
        if(!flag)
            return flag;
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return validPalindrome(s.substring(0,i)+s.substring(i+1,s.length()),false)||
                       validPalindrome(s.substring(0,j)+s.substring(j+1,s.length()),false);
            }
            i++;
            j--;
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String input = "ebcbbececabbacecbbcbe";
        boolean result = validPalindrome(input,true);
        System.out.println(result);
        
    }
    
}
