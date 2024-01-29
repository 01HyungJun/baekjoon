#include <iostream>
#include <vector>
using namespace std;

class Graph {
public:
	int M, N, K;
	vector<vector<bool>> field;
	vector<vector<bool>> visited;

	Graph(int m, int n, int k) : M(m), N(n), K(k) {
		field.resize(N + 1, vector<bool>(M + 1, false));
		visited.resize(N + 1, vector<bool>(M + 1, false));

		for (int j = 0; j < K; j++) {
			int x, y;
			cin >> x >> y;
			field[y][x] = true;
		}
	}

	~Graph() {
		vector<vector<bool>>().swap(field);
		vector<vector<bool>>().swap(visited);
	}

	int dfsAll() {
		int component = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (field[i][j] && !visited[i][j]) {
					dfs(i, j);
					component++;
				}
			}
		}
		return component;
	}

private:
	void dfs(int y, int x) {
		visited[y][x] = true;
		if (field[y][x + 1] && !visited[y][x + 1]) dfs(y, x + 1);
		if (field[y + 1][x] && !visited[y + 1][x]) dfs(y + 1, x);
		if ((x - 1 >= 0) && field[y][x - 1] && !visited[y][x - 1]) dfs(y, x - 1);
		if ((y - 1 >= 0) && field[y - 1][x] && !visited[y - 1][x]) dfs(y - 1, x);
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int T, M, N, K;
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> M >> N >> K;

		Graph* g = new Graph(M, N, K);
		cout << g->dfsAll() << "\n";
		delete g;
	}
	
}