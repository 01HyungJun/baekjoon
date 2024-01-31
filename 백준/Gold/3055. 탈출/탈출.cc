#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Graph {
public:
	int R, C, count = 0;
	int sx, sy, gx, gy;
	int dx[4] = { 1, 0, -1, 0 };
	int dy[4] = { 0, 1, 0, -1 };

	vector<vector<int>> forest;
	vector<vector<bool>> visited;
	queue<pair<int, int>> hq;
	queue<pair<int, int>> wq;

	Graph(int r, int c) : R(r), C(c) {
		forest.resize(R + 2, vector<int>(C + 2, 0));
		visited.resize(R + 2, vector<bool>(C + 2, false));

		char temp;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				cin >> temp;
				if (temp == '.') forest[i][j] = 1;
				else if (temp == 'X') forest[i][j] = 0;
				else if (temp == '*') {
					forest[i][j] = 2;
					visited[i][j] = true;
					wq.emplace(i, j);
				}
				else if (temp == 'D') {
					forest[i][j] = 3;
					gx = j; gy = i;
				}
				else if (temp == 'S') {
					forest[i][j] = 1;
					sx = j; sy = i;
				}
			}
		}
	}

	int bfsTime() {
		visited[sy][sx] = true;
		hq.emplace(sy, sx);

		while (!hq.empty()) {
			int hsize = hq.size();
			int wsize = wq.size();
			count++;
			for (int i = 0; i < wsize; i++) {
				int cwy = wq.front().first;
				int cwx = wq.front().second;
				wq.pop();
				for (int j = 0; j < 4; j++) {
					int nwy = cwy + dy[j];
					int nwx = cwx + dx[j];
					if (forest[nwy][nwx] == 1 && !visited[nwy][nwx]) {
						forest[nwy][nwx] = 2;
						visited[nwy][nwx] = true;
						wq.emplace(nwy, nwx);
					}
				}
			}
			for (int i = 0; i < hsize; i++) {
				int chy = hq.front().first;
				int chx = hq.front().second;
				hq.pop();
				for (int j = 0; j < 4; j++) {
					int nhy = chy + dy[j];
					int nhx = chx + dx[j];
					if (forest[nhy][nhx] == 1) {
						if (!visited[nhy][nhx]) {
							visited[nhy][nhx] = true;
							hq.emplace(nhy, nhx);
						}
					}
					else if (forest[nhy][nhx] == 3) {
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

	int R, C;
	cin >> R >> C;

	Graph* g = new Graph(R, C);
	int result = g->bfsTime();
	if (result != -1) cout << result;
	else cout << "KAKTUS";
	delete g;
}