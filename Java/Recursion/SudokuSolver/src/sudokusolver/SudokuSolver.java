/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

/**
 *
 * @author lucky
 */
public class SudokuSolver {

    /**
     * @param args the command line arguments
     */
    public static boolean canPlace(char[][]board, char value,int row,int col){
        //check value on all columns of row = row
        //System.out.println("Columns of row "+row);
        for(int i = 0; i<board[row].length; i++){
            //System.out.print(board[row][i]+"   ");
            if(board[row][i]==value)
                return false;
        }
        //System.out.println();
        //chek value on all rows of column = col;
        //System.out.println("Rows of column "+col);
        for(int i = 0; i<board.length; i++){
            //System.out.print(board[i][col]+"   ");
            if(board[i][col]==value)
                return false;
        }
        //check value on all rows and cols for subgrid
        int index = (int) Math.sqrt(board.length);
        int sRow = row/index;
        int sCol = col/index;
        
        //System.out.println();
        //chek value on all rows of column = col;
        //System.out.println("Subgrid "+sRow + "  "+ sCol);
        
        for(int i = sRow*index; i <sRow*index + index; i++){
            for(int j = sCol*index; j<sCol*index + index; j++){
                //System.out.print(board[i][j]+"  ");
                if(board[i][j]==value){
                    return false;
                }
            }
             //System.out.println();
        }
        
        return true;
        
    }
    public static boolean solveHelper(char[][]board, int row, int col){
        //System.out.println("row "+row+"  col  "+ col);
        if(col==board[row].length){
            col = 0;
            row++;
            if(row==board.length){
               //System.out.println("Acabe");
               return true;
            }
                
                
        }
        if(board[row][col]!='.'){
            return solveHelper(board,row,col+1);
        }
            
        
        for(int i = 1; i<=board.length; i++){
            char value = (char) (i + '0');
            if(canPlace(board,value,row,col)){
                 board[row][col]=value;
                 if(solveHelper(board,row,col+1))
                     return true;
                 board[row][col]='.';
            }
            
               
        }
        
        return false;
    }
    public static boolean solveSudoku(char[][] board){
        return solveHelper(board,0,0);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        char board[][] ={{'1','2','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        boolean resp = solveSudoku(board);
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();   
        }
    }
    
}
