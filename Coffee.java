import java.util.*;

public class coffee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        int MAX = 200000;

        int[] diff = new int[MAX + 2];

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            diff[l]++;
            diff[r + 1]--;
        }

        int[] pref = new int[MAX + 1];

        int cover = 0;

        for (int i = 1; i <= MAX; i++) {
            cover += diff[i];

            if (cover >= k)
                pref[i] = pref[i - 1] + 1;
            else
                pref[i] = pref[i - 1];
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            sb.append(pref[b] - pref[a - 1]).append('\n');
        }

        System.out.print(sb);
    }
}
