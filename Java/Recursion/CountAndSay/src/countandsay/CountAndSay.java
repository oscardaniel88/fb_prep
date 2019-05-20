/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package countandsay;

/**
 *
 * @author ocamarena
 */
public class CountAndSay {

    /**
     * @param args the command line arguments
     */
    
    public static String countAndSay(String input){
        int count = 1;
        int i = 0;
        int j = i+1;
        if(input.length()==0){
            return "1";
        }
        StringBuilder result = new StringBuilder();
        while(i<input.length()&& j<input.length()){
            if(input.charAt(i)==input.charAt(j)){
                count ++;
                j++;
            }else{
                result.append(count);
                result.append(input.charAt(i));
                i = j;
                j= i+1;
                count = 1;
            }
            
        }
        result.append(count);
        result.append(input.charAt(i));
        //System.out.println(result.toString());
        return result.toString();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String input = "";
        int n = 15;
        String result = "";
        for(int i =1; i<=n; i++){
           result = countAndSay(input);
           input = result;
        }
        System.out.println(result);
    }
    
}
