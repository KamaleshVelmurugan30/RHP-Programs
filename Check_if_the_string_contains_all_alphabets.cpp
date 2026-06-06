#include <iostream>
using namespace std;
int main()
{
    string str;
    cin>>str;
    int flagSmall = 0;
    int flagCaps = 0;
    for(int i = 0;str[i];i++){
        if (str[i] >= 'a' && str[i] <= 'z'){
            flagSmall = flagSmall | (1<<(str[i] - 'a'));
        }
        if (str[i] >= 'A' && str[i] <= 'Z'){
            flagCaps =flagCaps | (1<<(str[i] - 'A'));
        }
    }
    if(flagSmall == (1<<26) - 1 && flagCaps == (1<<26) - 1){
        cout<<"YES";
    }
    else{
        cout<<"NO";
    }
    return 0;
}
