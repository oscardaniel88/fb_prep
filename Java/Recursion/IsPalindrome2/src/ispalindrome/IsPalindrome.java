/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ispalindrome;

/**
 *
 * @author lucky
 */
public class IsPalindrome {
    
    public static boolean isPal(String s){
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        if(s.charAt(0) == s.charAt(s.length()-1)){
            return isPal(s.substring(1, s.length()-1));
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "ANNA";
        boolean isPalindrome = false;
        isPalindrome = isPal(s);
        System.out.println(isPalindrome);
    }
    
}
