import java.util.Scanner;
public class LongestCommonSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.nextLine();
        String text2 = sc.nextLine();
        System.out.println(solve(text1,text2));
        sc.close();
    }
    static int solve(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        for(int i = 0; i < l1+1; i++) {
            for(int j = 0; j < l2+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[l1][l2];
    }
}
