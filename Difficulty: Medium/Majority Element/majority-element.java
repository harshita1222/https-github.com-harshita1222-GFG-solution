//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // your code here
        
        int n = arr.length;
        int el = 0, cnt = 0;
        
        for(int nums : arr) {
            
            if(cnt == 0) {
                el = nums;
                cnt = 1;
            }
            else if(el == nums)
                cnt++;
            else 
                cnt--;
        }
        
        int count = 0;
        for(int nums : arr) {
            if(el == nums) count++;
            if(count > n/2) return el;
        }
        
        return -1;

    }
}