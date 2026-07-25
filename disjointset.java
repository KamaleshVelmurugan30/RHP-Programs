import java.util.*;
public class disjointset {
    public static void join(int[] ldr, int lft, int rgt){
        int ldrlt = find(ldr,lft);
        int ldrrt =find(ldr,rgt);
        ldr[ldrrt] = ldrlt;
    }
    public static int find(int[] ldr, int node){
        if(ldr[node] != node){
            ldr[node]  =  find(ldr, ldr[node]);
        }
        return ldr[node];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
       int[] ldr =new  int[n+1];
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            ldr[i] = i;
        }
for(int i=0;i<m;i++){
    int lt = sc.nextInt();
    int rt = sc.nextInt();
    join(ldr,lt,rt);
}
for(int i=1;i<=n;i++){
    set.add(find(ldr,i));
}
System.out.println(set.size());
    }
}
