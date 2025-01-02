//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to return Breadth First Traversal of given graph.
    vector<int> bfsOfGraph(vector<vector<int>> &adj) {
        int size = adj.size();
        vector<int> isVisited(size, 0);
        vector<int> bfs;
        queue<int> q;
        q.push(0);
        isVisited[0] = 1;
        while (!q.empty())
        {
            int node = q.front();
            q.pop();
            bfs.push_back(node);
            for (auto neighbour : adj[node])
            {
                if (!isVisited[neighbour])
                {
                    isVisited[neighbour] = 1;
                    q.push(neighbour);
                }
            }
        }
        return bfs;
    }
};


//{ Driver Code Starts.

int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >> E;

        // Now using vector of vectors instead of array of vectors
        vector<vector<int>> adj(V);

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u); // For undirected graph, add both u->v and v->u
        }

        Solution obj;
        vector<int> ans = obj.bfsOfGraph(adj);
        for (int i = 0; i < ans.size(); i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
    }
    return 0;
}

// } Driver Code Ends