#include<iostream>
using namespace std;
int main(){
    int n,q;
    cin>>n>>q;
    long long prefix[n+1];
    prefix[0] = 0;
    for(int i = 1; i <= n; i++){
        int x;
        cin>>x;
        prefix[i] = prefix[i-1] + x;
    }
    for(int i = 0; i < q; i++){
        int l,r;
        cin>>l>>r;
        cout<<prefix[r] - prefix[l-1]<<endl;
    }
    return 0;
}
