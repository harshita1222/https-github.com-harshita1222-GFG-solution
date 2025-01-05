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

function main() {
    let t = parseInt(readLine());
    for (let i = 0; i < t; i++) {
        let arr = readLine().split(' ').map(x => parseInt(x, 10));
        let X = parseInt(readLine(), 10);
        let obj = new Solution();
        console.log(obj.search(arr, X));
        console.log('~');
    }
}

// } Driver Code Ends


// User function Template for javas

class Solution {
    search(arr, x) {
        // write your code here
        let index = -1
        for(let i=0; i<arr.length; i++) {
            if(x == arr[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}


