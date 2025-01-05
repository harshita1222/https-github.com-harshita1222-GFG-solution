//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            String ans = ob.longestCommonPrefix(arr);

            if (ans.isEmpty()) {
                System.out.print("\"\"");
            } else {
                System.out.print(ans);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public String longestCommonPrefix(String arr[]) {
        int space = arr[0].length();
        for (int i = 0; i < arr.length; i++) {
            if (space > arr[i].length())
                space = arr[i].length();
        }

        StringBuffer str = new StringBuffer(space);

        for (int i = 0; i < space; i++) {
            char c = arr[0].charAt(i);
            for (int j = 1; j < arr.length; j++) {
                if (arr[j].charAt(i) != c) {
                    return str.toString();
                }
            }
            str.insert(i, c);
        }
        return str.toString();
    }
}


