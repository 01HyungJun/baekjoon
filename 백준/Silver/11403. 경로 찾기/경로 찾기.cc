#include <iostream>
#include <vector>
using namespace std;

class Graph {
public:
	int N;

	vector<vector<int>> adj;
	vector<vector<bool>> visited;

	Graph(int n) : N(n) {
		adj.resize(N, vector<int>(N, 0));
		visited.resize(N, vector<bool>(N, false));

		int temp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cin >> temp;
				adj[i][j] = temp;
			}
		}
	}

	~Graph() {
		vector<vector<int>>().swap(adj);
		vector<vector<bool>>().swap(visited);
	}

	void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) cout << 1 << " ";
				else cout << 0 << " ";
			}
			cout << "\n";
		}
	}

	void dfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (adj[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
				}
			}
		}
	}

private:
	void dfs(int curr, int next) { // curr == next이면 true로 바꾸고 continue;
		visited[curr][next] = true;
		
		for (int i = 0; i < N; i++) {
			if ((adj[next][i] == 1) && !visited[curr][i]) {
				if (curr == i) {
					visited[curr][i] = true;
					continue;
				}
				else {
					dfs(curr, i);
				}
			}
		}
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int N;
	cin >> N;

	Graph* g = new Graph(N);
	g->dfs();
	g->print();
	delete g;
}