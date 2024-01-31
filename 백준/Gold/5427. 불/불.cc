#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Graph {
public:
	int W, H, count = 0;
	int sx, sy;
	int dx[4] = { 1, 0, -1, 0 };
	int dy[4] = { 0, 1, 0, -1 };

	vector<vector<int>> building;
	vector<vector<bool>> visited;
	queue<pair<int, int>> human_q;
	queue<pair<int, int>> fire_q;

	Graph(int w, int h) : W(w), H(h) {
		building.resize(H + 2, vector<int>(W + 2, 3));	// 3 = 탈출 공간
		visited.resize(H + 2, vector<bool>(W + 2, false));

		string temp;
		for (int i = 1; i <= H; i++) {
			cin >> temp;
			for (int j = 0; j < W; j++) {
				if (temp[j] == '.') building[i][j + 1] = 1;	// 1 = 빈 공간
				else if (temp[j] == '#') building[i][j + 1] = 0;	// 0 = 벽
				else if (temp[j] == '*') {
					building[i][j + 1] = 2;	// 2 = 불
					fire_q.emplace(i, j + 1);
					visited[i][j + 1] = true;
				}
				else if (temp[j] == '@') {
					sx = j + 1;
					sy = i;
					building[i][j + 1] = 1;
				}
			}
		}
	}

	~Graph() {
		vector<vector<int>>().swap(building);
		vector<vector<bool>>().swap(visited);
		queue<pair<int, int>>().swap(human_q);
		queue<pair<int, int>>().swap(fire_q);
	}

	int bfsTime() {
		visited[sy][sx] = true;
		human_q.emplace(sy, sx);

		while (!human_q.empty()) {
			int f_size = fire_q.size();
			int h_size = human_q.size();
			count++;	// level
			for (int i = 0; i < f_size; i++) {	// fire_q bfs
				int c_fire_y = fire_q.front().first;
				int c_fire_x = fire_q.front().second;
				fire_q.pop();
				for (int j = 0; j < 4; j++) {
					int n_fire_y = c_fire_y + dy[j];
					int n_fire_x = c_fire_x + dx[j];
					if (building[n_fire_y][n_fire_x] == 1 && !visited[n_fire_y][n_fire_x]) {	// 사람이 지나갔던 곳도 번져야하나? 굳이?
						building[n_fire_y][n_fire_x] = 2;
						visited[n_fire_y][n_fire_x] = true;
						fire_q.emplace(n_fire_y, n_fire_x);
					}
				}
			}
			for (int i = 0; i < h_size; i++) {	// human_q bfs
				int c_human_y = human_q.front().first;
				int c_human_x = human_q.front().second;
				human_q.pop();
				for (int j = 0; j < 4; j++) {
					int n_human_y = c_human_y + dy[j];
					int n_human_x = c_human_x + dx[j];
					if (building[n_human_y][n_human_x] == 1) {
						if (!visited[n_human_y][n_human_x]) {
							visited[n_human_y][n_human_x] = true;
							human_q.emplace(n_human_y, n_human_x);
						}
					}
					else if (building[n_human_y][n_human_x] == 3) {
						return count;
					}
				}
			}
		}
		return -1;
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int T, W, H;
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> W >> H;
		Graph* g = new Graph(W, H);
		int result = g->bfsTime();
		if (result != -1) cout << result << "\n";
		else cout << "IMPOSSIBLE\n";
		delete g;
	}
}