#include <iostream>
#include <unordered_map>
#include <algorithm>
#include <vector>
using namespace std;


int find(vector<int> &ldr, int id){
    if(ldr[id] == id) return id;
    ldr[id] = find(ldr, ldr[id]);
    return ldr[id];
}

void join(vector<int> &ldr, int lt, int rt){
    ldr[find(ldr,lt)] = find(ldr,rt);
}

void solve(){
    int n,q;cin>>n>>q;
    vector<int> seq(n+1),ldr(n+1);
    unordered_map<int,int> vlm,lvm;
    for(int i=1;i<=n;i++) {
        cin>>seq[i];
        if(vlm.find(seq[i]) == vlm.end()){
            vlm[seq[i]] = i;
            lvm[i] = seq[i];
        }
        ldr[i] = vlm[seq[i]];

    }
    while(q--){
        int choice;cin>>choice;
        if(choice == 1){
            int from, to;cin>>from>>to;
            if(from==to) continue;
            if(vlm.find(from)==vlm.end()) continue;
            if(vlm.find(to) != vlm.end()){
                join(ldr, vlm[from], vlm[to]);
                lvm.erase(vlm[from]);
                vlm.erase(from);
            }else{
                int repIdx = vlm[from];
                lvm[repIdx] = to;
                vlm.erase(from);
                vlm[to] = repIdx;
            }
        } else {
            int idx;cin>>idx;
            if(idx>=n+1)cout<<0<<"\n";
            else cout<<lvm[find(ldr,ldr[idx])]<<"\n";
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int TC;cin>>TC;
    int idx = TC;
    while(TC--){
        cout<<"Case "<<idx-TC<<":"<<"\n";
        solve();
    }
}
