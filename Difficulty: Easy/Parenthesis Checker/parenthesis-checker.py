#User function Template for python3

class Solution:
    #Function to check if brackets are balanced or not.
    def isParenthesisBalanced(self, s):
        # code here
        a=[]
        if len(s) == 1 :
            return 0
        for i in s:
            if i =='(' or i =='{' or i =='[':
                a.append(i)
            elif not a:
                return False
            elif i == '}' and a.pop() != '{':
                return False
            elif i == ')' and a.pop() != '(':
                return False
            elif i == ']' and a.pop() != '[':
                return False
            
        if a:
            return False
        else:
            return True




#{ 
 # Driver Code Starts
#Initial Template for Python 3

import atexit
import io
import sys

#Contributed by : Nagendra Jha

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER


@atexit.register
def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())


if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        #n = int(input())
        #n,k = map(int,imput().strip().split())
        #a = list(map(int,input().strip().split()))
        s = str(input())
        obj = Solution()
        if obj.isParenthesisBalanced(s):
            print("true")
        else:
            print("false")
        print("~")

# } Driver Code Ends