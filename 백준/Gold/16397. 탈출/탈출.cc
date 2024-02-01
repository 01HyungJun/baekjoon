#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Graph {
public:
	int N, T, G;
	int count = 0;

	vector<bool> visited;
	queue<int> q;

	Graph(int n, int t, int g) : N(n), T(t), G(g) {
		visited.resize(100000, false);
	}

	~Graph() {
		vector<bool>().swap(visited);
		queue<int>().swap(q);
	}

	int bfsOP() {
		visited[N] = true;
		q.push(N);
		while (!q.empty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cx = q.front();
				if (cx == G) return count;
				q.pop();
				for (int j = 0; j < 2; j++) {
					int nx;
					if (j == 0) {
						nx = cx + 1;
					}
					else {
						if (cx != 0) {
							int cnt = 1;
							int temp = cx * 2;
							if (temp > 99999) continue;
							while (temp >= 10) {
								temp /= 10;
								cnt *= 10;
							}
							nx = cx * 2 - cnt;
						}
						else continue;
					}

					if (nx > 99999) continue;
					if (!visited[nx]) {
						visited[nx] = true;
						q.push(nx);
					}
				}
			}
			if (count == T) return -1;
			count++;
		}
		return -1;
	}

};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int N, T, G;
	cin >> N >> T >> G;

	Graph* g = new Graph(N, T, G);
	int result = g->bfsOP();
	if (result != -1) cout << result;
	else cout << "ANG";
	delete g;
}