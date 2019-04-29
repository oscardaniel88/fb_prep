/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validsudoku;

/**
 *
 * @author ocamarena
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
		short[]rows = new short[board.length];
                short[]cols = new short[board.length];
                short[]squares = new short[board.length];
                
                for (int i = 0; i < board.length; i++){
                    for(int j = 0; j < board[0].length; j++){
                        if(board[i][j]=='.')
                            continue;
                        short value = (short)(1<<board[i][j]-'1');
                        if((value & rows[i])>0) return false;
                        if((value & cols[j])>0) return false;
                        if((value & squares[3*(i/3)+(j/3)])>0) return false;
                        
                        rows[i]|=value;
                        cols[j]|=value;
                        squares[3*(i/3)+(j/3)] |= value;
                    }
                }
		
		return true;
	}

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(board));
	}
    
}
