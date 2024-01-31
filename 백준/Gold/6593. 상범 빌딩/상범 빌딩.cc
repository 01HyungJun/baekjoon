#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
using namespace std;

class Graph {
public:
	int L, R, C, count = 0;
	int sx, sy, sz;
	int ex, ey, ez;
	int dx[6] = { 1, 0, -1, 0, 0, 0 };
	int dy[6] = { 0, 1, 0, -1, 0, 0 };
	int dz[6] = { 0, 0, 0, 0, 1, -1 };

	vector<vector<vector<int>>> building;
	vector<vector<vector<bool>>> visited;
	queue<tuple<int, int, int>> q;

	Graph(int l, int r, int c) : L(l), R(r), C(c) {
		building.resize(L + 2, vector<vector<int>>(R + 2, vector<int>(C + 2, 0)));
		visited.resize(L + 2, vector<vector<bool>>(R + 2, vector<bool>(C + 2, false)));

		char temp;
		for (int i = 1; i <= L; i++) {
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					cin >> temp;
					if (temp == '#') continue;
					else if (temp == '.') { building[i][j][k] = 1; continue; }
					else if (temp == 'S') { sz = i; sy = j; sx = k; }
					else if (temp == 'E') { ez = i; ey = j; ex = k; }
					building[i][j][k] = 1;
				}
			}
		}
	}

	~Graph() {
		vector<vector<vector<int>>>().swap(building);
		vector<vector<vector<bool>>>().swap(visited);
		queue<tuple<int, int, int>>().swap(q);
	}

	int bfsTime() {
		visited[sz][sy][sx] = true;
		q.emplace(sz, sy, sx);

		while (!q.empty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cz = get<0>(q.front());
				int cy = get<1>(q.front());
				int cx = get<2>(q.front());
				if (cz == ez && cy == ey && cx == ex) return count;
				q.pop();
				for (int k = 0; k < 6; k++) {
					int nz = cz + dz[k];
					int ny = cy + dy[k];
					int nx = cx + dx[k];
					if (building[nz][ny][nx] && !visited[nz][ny][nx]) {
						visited[nz][ny][nx] = true;
						q.emplace(nz, ny, nx);
					}
				}
			}
			count++;
		}
		return -1;
	}

};

int main() {
	int L, R, C;

	while (1) {
		cin >> L >> R >> C;
		if (L == 0 && R == 0 && C == 0) break;

		Graph* g = new Graph(L, R, C);
		int result = g->bfsTime();
		if (result != -1) cout << "Escaped in " << result << " minute(s).\n";
		else cout << "Trapped!\n";
		delete g;
	}
}