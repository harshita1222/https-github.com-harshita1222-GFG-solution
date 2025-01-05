//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution {
  public:
    // Function to find the smallest positive number missing from the array.
    int missingNumber(vector<int> &arr) {
        priority_queue<int> maxHeap;
        maxHeap.push(0);
        for(int i=0;i<arr.size();i++){
            if(arr[i]>=0){
                maxHeap.push(arr[i]);

            }
        }
        int res= maxHeap.top()+1;
        while(maxHeap.size()>0){
            int a= maxHeap.top();
            maxHeap.pop();
            if(a-maxHeap.top()>1){
                res=maxHeap.top()+1;
            }
        }
        return res;
    }
};



//{ Driver Code Starts.

// int missingNumber(int arr[], int n);

int main() {

    // taking testcases
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {

        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        int result = ob.missingNumber(arr);
        cout << result << "\n";
    }
    return 0;
}
// } Driver Code Ends