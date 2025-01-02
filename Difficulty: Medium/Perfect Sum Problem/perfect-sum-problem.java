//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends

class Solution {
    
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n= nums.length;
        int count=0;
        for(int i:nums) if(i==0) count++;
        Arrays.sort(nums);


        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        int[][] dp=new int[n-count][target+1];


        for(int[] row:dp) Arrays.fill(row,-1);


        int ind=n-count-1;


        if(ind<0) return (int) Math.pow(2,count);

        int ans=find(ind,target,nums,dp);


        return count!=0?(int)Math.pow(2,count)*ans:ans;
    }


    private static int find(int i,int target,int[] arr,int[][] dp){
        
        if(i<0) return 0;

        if(dp[i][target]!=-1) return dp[i][target];

        if (target == 0)
            return 1;

        if (i == 0)
            return arr[0] == target ? 1 : 0;

        int notTake=find(i-1,target,arr,dp);
        int take=0;
        if(target>=arr[i]){
            take = find(i-1,target-arr[i],arr,dp);

        }

        return dp[i][target] = take+notTake;
    }
}


