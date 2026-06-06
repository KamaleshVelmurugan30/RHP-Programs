#include <iostream>
using namespace std;

int main() {
    string str;
    
    cout << "Enter a string: ";
    cin>>str;
    
    int n = str.length();
    int totalCombinations = (1 << n);
    
    for (int i = 0; i < totalCombinations; i++) {
        string current = "";
        
        for (int j = 0; j < n; j++) {
            if (i & (1 << j)) {
                current += str[j];
            }
        }
        cout<<current << endl;
    }

    
    return 0;
}
