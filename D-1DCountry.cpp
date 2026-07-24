#include<bits/stdc++.h>

using namespace std;
void solve(){
    int N; cin>> N;
    vector<int> loc(N);
    vector<long long int> vpsum(N+1, 0);
    for(int i=0;i<N;i++) cin>> loc[i];
    for(int i=1;i<N+1;i++){
        int ppl; cin>>ppl;
        vpsum[i] += vpsum[i-1] + ppl;
    }
    int Q; cin>>Q;
    while(Q--){
        int ql,qr; cin>>ql>>qr;
        int lt = lower_bound(loc.begin(),loc.end(),ql) - loc.begin();

        int rt = upper_bound(loc.begin(),loc.end(),qr) - loc.begin();
        cout<<vpsum[rt] - vpsum[lt]<<"\n";
    }
}
int main(){
   ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    solve();
}
