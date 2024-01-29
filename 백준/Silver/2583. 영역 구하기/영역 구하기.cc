#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Graph {
public:
	int M, N;

	vector<vector<bool>> paper;
	vector<vector<bool>> visited;
	vector<int> count;

	Graph(int m, int n, int k) : M(m), N(n) {
		paper.resize(M + 2, vector<bool>(N + 2, true));
		visited.resize(M + 2, vector<bool>(N + 2, false));

		vector<bool> temp(N + 2, false);
		paper[0] = temp;
		paper[M + 1] = temp;
		for (int i = 1; i < M + 1; i++) {
			paper[i][0] = false;
			paper[i][N + 1] = false;
		}

		int x1, y1, x2, y2;
		for (int a = 0; a < k; a++) {
			cin >> x1 >> y1 >> x2 >> y2;
			x1++; y1++;
			for (int i = y1; i <= y2; i++) {
				for (int j = x1; j <= x2; j++) {
					paper[i][j] = false;
				}
			}
		}
	}

	~Graph() {
		vector<vector<bool>>().swap(paper);
		vector<vector<bool>>().swap(visited);
		vector<int>().swap(count);
	}

	int dfsAll() {
		int component = 0;
		for (int i = 1; i < M + 2; i++) {
			for (int j = 1; j < N + 2; j++) {
				if (paper[i][j] && !visited[i][j]) {
					count.push_back(dfs(i, j));
					component++;
				}
			}
		}
		sort(count.begin(), count.end());
		return component;
	}
private:
	int dfs(int i, int j) {
		int cnt = 1;
		visited[i][j] = true;
		if (paper[i][j + 1] && !visited[i][j + 1]) cnt += dfs(i, j + 1);
		if (paper[i + 1][j] && !visited[i + 1][j]) cnt += dfs(i + 1, j);
		if (paper[i][j - 1] && !visited[i][j - 1]) cnt += dfs(i, j - 1);
		if (paper[i - 1][j] && !visited[i - 1][j]) cnt += dfs(i - 1, j);
		return cnt;
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int M, N, K;
	cin >> M >> N >> K;

	Graph* g = new Graph(M, N, K);
	cout << g->dfsAll() << "\n";
	
	for (int& c : g->count) {
		cout << c << " ";
	}
}