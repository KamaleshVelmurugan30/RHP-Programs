import java.util.Scanner;
public class NumberOfIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] grid = new char[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(solve(grid));
        sc.close();
    }
    static final int[][] path = {{-1,0},{1,0},{0,-1},{0,1}};
    static int solve(char[][] grid) {
        int lands = 0;
        int R = grid.length;
        int C = grid[0].length;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(grid[i][j] == '1') {
                    lands++;
                    dfs(grid,R,C,i,j);
                }
            }
        }
        return lands;
    }
    static void dfs(char[][] grid, int R,int C, int r, int c) {
        grid[r][c] = '0';
        for(int i = 0; i < 4; i++) {
            int newRow = r + path[i][0];
            int newCol = c + path[i][1];
            if(newRow >= 0 && newRow < R && newCol >= 0 && newCol < C) {
                if(grid[newRow][newCol] == '1') {
                    dfs(grid, R, C, newRow, newCol);
                }
            }
        }
    }
}
