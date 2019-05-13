/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ocamarena
 */
public class NQueens {

    /**
     * @param args the command line arguments
     */
    
    public static String[][] createBoard(int n){
        String[][] board = new String[n][n];
        for(int i = 0; i <n ; i++){
            for(int j = 0; j<n ; j++){
                board[i][j]=".";
            }
        }
        return board;
    }
    
    public static void placeQueen(String[][]board,int row, int col){
        board[row][col]="Q";
    }
    
    public static void removeQueen(String[][]board,int row,int col){
        board[row][col]=".";
    }
    public static boolean isSafe(String[][]board,int row, int col){
        if(board[row][col].equals("Q")) return false;
        //Check Rows
        for(int i = 0; i<board.length; i++){
            if(board[i][col].equals("Q")) return false;
        }
        //Check Columns
        for(int j = 0; j<board.length; j++){
            if(board[row][j].equals("Q")) return false;
        }
        //Check diagonal 1
        String [] diag1 = getDigonal1(board,row,col);
        for(int i = 0; i<diag1.length; i++){
            if(diag1[i] != null && diag1[i].equals("Q")) return false;
        }
        String [] diag2 = getDigonal2(board,row,col);
        for(int i = 0; i<diag2.length; i++){
            if(diag2[i] != null && diag2[i].equals("Q")) return false;
        }
        return true;
    }
    
    public static String[] getDigonal1(String[][] board, int row, int col){
        String [] result = new String[board.length];
        int i = row;
        int j = col;
        int count = 0;
        while(i >= 0 && j >= 0){
            result[count]=board[i][j];
            i--;
            j--;
            count++;
        }
        i = row+1;
        j = col+1;
        //count ++;
        while(i<board.length && j<board.length){
            result[count] = board[i][j];
            i++;
            j++;
            count++;
        }
        return result;
        
    }
    public static String[] getDigonal2(String[][] board, int row, int col){
        String [] result = new String[board.length];
        int i = row;
        int j = col;
        int count = 0;
        while(i >= 0 && j < board.length){
            result[count]=board[i][j];
            i--;
            j++;
            count++;
        }
        i = row+1;
        j = col-1;
        //count ++;
        while(i<board.length && j>0){
            result[count] = board[i][j];
            i++;
            j--;
            count++;
        }
        return result;
        
    }
    public static void helper (String[][]board,int col, List<String> current, List<List<String>> result){
        if(col >=board.length){
            //We finished;
            System.out.println("---------Solucion----------");
            for(int i = 0; i<board.length; i++){
                String temp = new String();
                for(int j = 0; j<board.length; j++){
                    temp = temp + board[i][j];
                    System.out.print(board[i][j]+"  ");
                }
                System.out.println();
                current.add(temp);
            }
            result.add(new ArrayList<>(current)); 
            current.remove(current.size()-1);
        }else{
            for(int i = 0; i<board.length; i++){
                if(isSafe(board,i,col)){
                    placeQueen(board,i,col);
                    helper(board,col+1,current,result);
                    removeQueen(board,i,col);
                }
                
            }
            
        }
        
    }
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        String[][]board = createBoard(n);
        helper(board,0,current,result);
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 8;
        List<List<String>> result = new ArrayList<>();
        result = solveNQueens(n);
        //System.out.println(Arrays.asList(result));
    }
    
}
