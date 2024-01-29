#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Graph {
public:
	int N, M;

	vector<vector<bool>> hallway;
	vector<vector<bool>> visited;

	Graph(int n, int m, int k) : N(n), M(m) {
		hallway.resize(N + 2, vector<bool>(M + 2, false));
		visited.resize(N + 2, vector<bool>(M + 2, false));

		for (int i = 0; i < k; i++) {
			int r, c;
			cin >> r >> c;
			hallway[r][c] = true;
		}
	}

	~Graph() {
		vector<vector<bool>>().swap(hallway);
		vector<vector<bool>>().swap(visited);
	}

	int dfsMax() {
		int maximum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (hallway[i][j] && !visited[i][j]) {
					maximum = max(maximum, dfs(i, j));
				}
			}
		}
		return maximum;
	}

private:
	int dfs(int r, int c) {
		int count = 1;
		visited[r][c] = true;
		if (hallway[r][c + 1] && !visited[r][c + 1]) count += dfs(r, c + 1);
		if (hallway[r + 1][c] && !visited[r + 1][c]) count += dfs(r + 1, c);
		if (hallway[r][c - 1] && !visited[r][c - 1]) count += dfs(r, c - 1);
		if (hallway[r - 1][c] && !visited[r - 1][c]) count += dfs(r - 1, c);
		return count;
	}

};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int N, M, K;
	cin >> N >> M >> K;

	Graph* g = new Graph(N, M, K);
	cout << g->dfsMax();
	delete g;
}