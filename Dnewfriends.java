import java.util.*;
public class DNewfriends {
    private static void join(int[] ldr , int lft, int rgt){
              int ldrrt = find(ldr,rgt);
              int ldrlt = find(ldr,lft);
              ldr[ldrrt] = ldrlt;
    }
    private static int find(int[] ldr, int node){
        if(ldr[node] != node){
            ldr[node] = find(ldr, ldr[node]);
        }
        return ldr[node];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] ldr = new int[n+1];
        int[] grp = new int[n+1];
        int[] edg = new int[n+1];
        int[] edges = new int[m];
        for(int i=1;i<=n;i++){
            ldr[i] = i;
        }
        for(int i=0;i<m;i++){
            int lt = sc.nextInt();
            edges[i] = lt;
            int rt = sc.nextInt();
            join(ldr,lt,rt);
        }
        for(int i=1;i<=n;i++){
            ldr[i] = find(ldr,i);
        }
        for(int i=1;i<=n;i++){
            int uldr = find(ldr,i);
            grp[uldr]++;
        }
        long ans = 0;

        for(int i = 0; i < m; i++) {
            edg[(find(ldr,edges[i]))]++;
        }
        for(int node=1;node<=n;node++){
            int ncnt = grp[node];
            ans += ((long) ncnt * (ncnt - 1))/2-edg[node];
        }
        System.out.println(ans);


    }
}
