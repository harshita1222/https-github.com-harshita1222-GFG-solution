//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  private:
    bool dfs(vector<vector<int>>& adj,vector<bool> &visited,vector<bool>& dfsVisited, int node){
        visited[node] = true;
        dfsVisited[node] = true;
        for(auto x: adj[node]){
            if(!visited[x]){
                bool test = dfs(adj , visited , dfsVisited, x);
                if(test){
                    return true;
                }
            }
            else if(dfsVisited[x]){
                return true;
            }
        }
        dfsVisited[node] = false;
        return false;
    }
  public:
    // Function to detect cycle in a directed graph.
    bool isCyclic(int V, vector<vector<int>> adj) {
         vector<bool> visited(adj.size(), false);
         vector<bool> dfsVisited(adj.size(), false);
         for(int i = 0; i < V; i++){
             if(!visited[i]){
                 bool cycle = dfs(adj , visited, dfsVisited, i);
                 if(cycle){
                     return true;
                 }
             }
         }
         return false;
    }
};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;

        vector<vector<int>> adj(V);

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
        }

        Solution obj;
        cout << obj.isCyclic(V, adj) << "\n";

        cout << "~"
             << "\n";
    }

    return 0;
}

// } Driver Code Ends