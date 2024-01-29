#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Graph {
public:
	int N;

	vector<vector<int>> adj;
	vector<bool> visited;

	Graph(int n, int m) : N(n) {
		adj.resize(N + 1);
		visited.resize(N + 1, false);
		for (int i = 0; i < m; i++) {
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		sortList();
	}

	~Graph() {
		vector<vector<int>>().swap(adj);
		vector<bool>().swap(visited);
	}

	void sortList() {
		for (int i = 0; i <= N; i++) sort(adj[i].begin(), adj[i].end());
	}

	int dfsAll() {
		int component = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				component++;
			}
		}
		return component++;
	}

private:
	void dfs(int curr) {
		visited[curr] = true;
		for (int& next : adj[curr]) {
			if(!visited[next]) dfs(next);
		}
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int N, M;

	cin >> N >> M;

	Graph* g = new Graph(N, M);
	cout << g->dfsAll();
	delete g;
}