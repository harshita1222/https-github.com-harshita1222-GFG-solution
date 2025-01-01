#User function Template for python3

class Solution:
    def knapSack(self, capacity, val, wt):
        n = len(val)
        # Create a DP table with dimensions (n+1) x (capacity+1)
        dp = [[0] * (capacity + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            for w in range(capacity + 1):
                if wt[i - 1] <= w:
                    # Item can be included or excluded
                    dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1])
                else:
                    # Item cannot be included, carry forward the previous value
                    dp[i][w] = dp[i - 1][w]
        # The last cell contains the maximum value we can achieve with the given capacity
        return dp[n][capacity]


#{ 
 # Driver Code Starts
if __name__ == '__main__':
    test_cases = int(input())
    for _ in range(test_cases):
        # Read capacity
        capacity = int(input())
        values = list(map(
            int,
            input().strip().split()))  # Using 'values' instead of 'val'
        weights = list(map(
            int,
            input().strip().split()))  # Using 'weights' instead of 'wt'
        ob = Solution()
        print(ob.knapSack(capacity, values, weights))
        print("~")

# } Driver Code Ends