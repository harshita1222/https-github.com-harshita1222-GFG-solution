#User function Template for python3
class Solution:
    def commonElements(self, arr1, arr2, arr3):
        set_arr1 = set(arr1)
        set_arr2 = set(arr2)
        set_arr3 = set(arr3)
        common_set = set_arr1.intersection(set_arr2).intersection(set_arr3)
        list_common = sorted(common_set)
        return list_common if list_common else [-1]



#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        brr = list(map(int, input().split()))
        crr = list(map(int, input().split()))
        ob = Solution()
        res = ob.commonElements(arr, brr, crr)
        if len(res) == 0:
            print(-1)
        else:
            print(" ".join(map(str, res)))
        print("~")
# } Driver Code Ends