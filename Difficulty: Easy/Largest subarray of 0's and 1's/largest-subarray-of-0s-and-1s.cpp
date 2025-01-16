//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int maxLen(vector<int> &arr) {
               map<int,int>x;
        int count1 = 0;
        int count0 = 0;
        x[count1 - count0] = 0;
        int ans = 0;
        for(int i=0; i<arr.size(); i++){
            if(arr[i] == 0) count0++;
            else count1++;
            
            int diff = count1 - count0;
            
            if(x.find(diff) != x.end()){
                ans = max(ans,i - x[diff] + 1);
            }
            else{
                x[diff]  = i+1;
            }
        }
        return ans;
    }


        // Your code here
    
};


//{ Driver Code Starts.

int main() {
    int T;
    cin >> T;
    cin.ignore(); // To ignore the newline character after reading T

    while (T--) {
        string line;
        getline(cin, line); // Read the whole line for the array

        // Convert the line into an array of integers
        stringstream ss(line);
        vector<int> a;
        int num;
        while (ss >> num) {
            a.push_back(num);
        }

        // Create the solution object
        Solution obj;

        // Call the maxLen function and print the result
        cout << obj.maxLen(a) << endl;
    }

    return 0;
}
// } Driver Code Ends