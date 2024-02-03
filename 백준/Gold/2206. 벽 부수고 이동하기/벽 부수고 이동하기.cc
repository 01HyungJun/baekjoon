#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
using namespace std;

class Graph {
public:
	int N, M, count = 0;
	int dx[4] = { 1, 0, -1, 0 };
	int dy[4] = { 0, 1, 0, -1 };

	vector<vector<int>> map;
	vector<vector<vector<bool>>> visited;	// 3차원으로 구성, z = 1 벽 부숨, z = 0 벽 안 부숨
	queue<tuple<bool, int, int>> q;	// 벽 안부셨으면 false, 부셨으면 true

	Graph(int n, int m) : N(n), M(m) {
		map.resize(N + 2, vector<int>(M + 2, 2));	// 0 = 이동 가능, 1 = 벽, 2 = 테두리
		visited.resize(2, vector<vector<bool>>(N + 2, vector<bool>(M + 2, false)));

		char temp;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				cin >> temp;
				map[i][j] = temp - '0';
			}
		}
	}

	~Graph() {
		vector<vector<int>>().swap(map);
		vector<vector<vector<bool>>>().swap(visited);
	}

	int bfsShort() {
		visited[0][1][1] = true;
		q.emplace(0, 1, 1);

		while (!q.empty()) {
			int size = q.size();
			count++;
			for (int i = 0; i < size; i++) {
				int cy, cx, cisBreak;
				tie(cisBreak, cy, cx) = q.front();
				if (cy == N && cx == M) return count;
				q.pop();
				for (int j = 0; j < 4; j++) {
					int ny = cy + dy[j];
					int nx = cx + dx[j];
					if (map[ny][nx] == 0) {
						if (!visited[cisBreak][ny][nx]) {
							visited[cisBreak][ny][nx] = true;
							q.emplace(cisBreak, ny, nx);
						}
					}
					else if (!cisBreak && map[ny][nx] == 1) {	// 벽을 부순 적이 없을 때, 벽을 만나면 부숨
						if (!visited[cisBreak][ny][nx]) {
							visited[cisBreak][ny][nx] = true;
							q.emplace(!cisBreak, ny, nx);
						}
					}
				}
			}
		}
		return -1;
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int N, M;
	cin >> N >> M;

	Graph* g = new Graph(N, M);
	int result = g->bfsShort();
	cout << result;
}