//{ Driver Code Starts
// Initial Template for javascript

'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => { inputString += inputStdin; });

process.stdin.on('end', () => {
    inputString = inputString.trim().split('\n').map(string => string.trim());
    main();
});

function readLine() { return inputString[currentLine++]; }

// Position this line where user code will be pasted.

function main() {
    let t = parseInt(readLine());
    for (let i = 0; i < t; i++) {
        let arr = readLine().split(' ').map(x => parseInt(x, 10));
        let k = parseInt(readLine(), 10);
        let obj = new Solution();
        console.log(obj.countPairs(arr, k));
        console.log('~');
    }
}

// } Driver Code Ends



class Solution {
    countPairs(arr, target) {
        // write your code here
        
        arr.sort((a,b) => a-b)
        let count =0;
        let left = 0;
        let right = arr.length-1;
        
        while(left<right){
            if(arr[left]+ arr[right] < target){
                count += right-left;
                left ++;
            }else{
                right --;
            }
        }
        return count;
    }
}
