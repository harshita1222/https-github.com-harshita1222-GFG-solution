//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int size = adj.size();
        boolean[] vis = new boolean[size];
                
        for(int node=0; node<size; node++) {
            if(!vis[node]) {
                // // using BFS
                // if(bfsIsCycle(node, adj, vis))
                //     return true;
                    
                // using DFS
                // passing parent as -1, for disconnected nodes
                if(dfsIsCycle(node, adj, vis, -1) == true) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    boolean dfsIsCycle(int node, ArrayList<ArrayList<Integer>> adj, 
                boolean[] vis, int parent)
        {
            // mark current node as visited
            vis[node] = true;
            
            // traverse all its neighbor nodes
            for(int neigh: adj.get(node)) {
                // before traversing to the neighbor, check if its parent
                // if 'Yes' then skip to other neighbor
                if(neigh == parent) continue;
                
                // if neighbor already visited then it means there is a cycle
                if(vis[neigh])
                    return true;
                    
                // if not visited then check for cycle in its neighbor
                if(dfsIsCycle(neigh, adj, vis, node) == true)
                    return true;
            }
            
            return false;
        }    
    
    boolean bfsIsCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        // this queue will store int[]{node, parent}
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        
        // mark the node as visited & push it into queue
        vis[node] = true;
        queue.add(new int[]{node, -1});
        
        while(!queue.isEmpty()) {
            int[] top = queue.pop();
            int currentNode = top[0];
            int currentParent = top[1];
            
            for(int neigh: adj.get(currentNode)) {
                if(neigh == currentParent) continue;
                
                if(vis[neigh]) return true;
                
                vis[neigh] = true;
                queue.add(new int[]{neigh, currentNode});
            }
        }
        
        return false;
    }
        
}
