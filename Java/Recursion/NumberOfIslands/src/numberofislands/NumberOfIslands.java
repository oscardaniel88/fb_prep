/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numberofislands;

/**
 *
 * @author ocamarena
 */
public class NumberOfIslands {

    /**
     * @param args the command line arguments
     */
    public static int dfs(char[][]grid, int i, int j){
        if(i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j]=='0'){
            return 0;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j+1);
        return 1;
    }
    public static int numberOfIslands(char[][]grid){
        int result = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    result += dfs(grid,i,j);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        char[][]grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int result = numberOfIslands(grid);
        System.out.println("Number of Islands  " + result);
        
    }
    
}
