import java.util.Scanner;
class SumOfAdjacentCells {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows: ");
        int r = sc.nextInt();
        System.out.println("Enter no. of cols: ");
        int c = sc.nextInt();
        int[][] matrix = new int[r][c];
        System.out.println("Enter matrix elements:");
    for(int i = 0; i < r; i++) {
        for(int j = 0; j < c; j++) {
            matrix[i][j] = sc.nextInt();
        }
    }
        System.out.println("Enter the cell value");
        int target = sc.nextInt();
        System.out.println(solve(matrix,target));
        sc.close();
    }
    static int solve(int[][] matrix,int target) {
        int R = matrix.length, C = matrix[0].length;
        int sum = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(matrix[i][j] == target) {
                    sum = findAns(matrix,i,j);
                    break;
                }
            }
        }
        return sum;
    }
    static int findAns(int[][] matrix,int r,int c) {
        int ans = 0;
        int[][] path = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i = 0; i < 8; i++) {
            int newRow = r + path[i][0];
            int newCol = c + path[i][1];
            if(newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length) {
                ans += matrix[newRow][newCol];
            }
        }
        return ans;
    }
}
