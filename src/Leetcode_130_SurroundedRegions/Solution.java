package Leetcode_130_SurroundedRegions;


//The key point of this solution is that only the '0's on the boarder and its connected 'O's could not be surrounded.
// Therefore, the DFS solution is to find 'O's on the boarders, and dfs to mark its connected 'O's.
public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        int x,y;

        for( y = 0; y < n; y++){
            x = 0;
            if(board[x][y] == 'o'){
                dfs(x,y,board);
            }
        }

        for( x = 0; x < m; x++){
            y = 0;
            if(board[x][y] == 'o'){
                dfs(x,y,board);
            }
        }
        for( x = 0; x < m; x++){
            y = n-1;
            if(board[x][y] == 'o'){
                dfs(x,y,board);
            }
        }
        for( y = 0; y < n; y++){
            x = m-1;
            if(board[x][y] == 'o'){
                dfs(x,y,board);
            }
        }


        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 'o') board[i][j] = 'x';
            }
        }

        for(int q = 0; q<m; q++){
            for(int w = 0; w<n; w++){
                if(board[q][w] == '*') board[q][w] = 'o';
            }
        }
    }

    public void dfs(int i,int j, char[][] board){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == 'x' || board[i][j] == '*') return;
        board[i][j] = '*';
        dfs(i-1,j,board);
        dfs(i+1,j,board);
        dfs(i,j-1,board);
        dfs(i,j+1,board);
        return;
    }


//    public void solve(char[][] board) {
//        if(board== null || board.length ==0) return;
//        int m = board.length, n = board[0].length;
//
//        // find 'O's on the boarders
//        for(int i =0; i<m; i++){
//            if(board[i][0] == 'O'){
//                dfs(board, i, 0);
//            }
//            if(board[i][n-1] == 'O'){
//                dfs(board, i, n-1);
//            }
//        }
//
//        // find 'O's on the boarders
//        for(int j=0; j<n; j++){
//            if(board[0][j] =='O'){
//                dfs(board, 0, j);
//            }
//            if(board[m-1][j] == 'O'){
//                dfs(board, m-1, j);
//            }
//        }
//
//        // after above dfs, '*' is the 'O's on the boarder or connected to the 'O' on the boarder, and 'O's are  the 'O's surrounded by 'X's
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(board[i][j] =='O'){
//                    board[i][j] = 'X';
//                }else if(board[i][j] == '*'){
//                    board[i][j] = 'O';
//                }
//            }
//        }
//
//    }
//
//    // set 'O's connected to the 'O's on the boarder to '*', to distinguish those 'O's
//    // not connected to the boarder 'O'
//    private void dfs(char[][] b, int i, int j){
//        if(i < 0 || i == b.length || j < 0 || j == b[0].length) return ;
//        if(b[i][j] == 'X' || b[i][j] =='*') return ;
//
//        b[i][j] = '*';
//        dfs(b, i+1, j);
//        dfs(b, i-1, j);
//        dfs(b, i, j-1);
//        dfs(b, i, j+1);
//    }
}

