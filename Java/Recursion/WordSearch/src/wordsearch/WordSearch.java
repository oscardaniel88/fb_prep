/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wordsearch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class WordSearch {

    /**
     * @param args the command line arguments
     */
    
    public static boolean dfs(char[][]board,int i, int j, int count, String word){
        if(count == word.length()){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[i].length||board[i][j]!=word.charAt(count)){
            return false;
        }
        char temp = board[i][j];
        board[i][j]=' ';
        boolean found = dfs(board,i+1,j,count+1,word)||
            dfs(board,i-1,j,count+1,word)||
            dfs(board,i,j-1,count+1,word)||
            dfs(board,i,j+1,count+1,word);
        board[i][j]=temp;
        return found;
    }
    
    public static boolean findWord(char[][]board, String word){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j]==word.charAt(0) && dfs(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        char [][] board ={{'a','b','b','a'},{'b','b','b','a'},{'a','b','a','b'},{'b','b','b','b'},{'a','b','a','b'},{'b','b','b','b'},{'a','b','a','b'},{'a','a','b','a'}};
        String word = "aabbb";
        boolean result = findWord(board,word);
        System.out.println(result);
    }
    
}
