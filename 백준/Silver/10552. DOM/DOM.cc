#include <iostream>
#include <unordered_map>
#include <algorithm>
using namespace std;

class Graph {
public:
	int N, M, P;

	unordered_map<int, int> channel;
	unordered_map<int, bool> visited;

	Graph(int n, int m, int p) : N(n), M(m), P(p) {
		int favo, hate;
		for (int i = 0; i < N; i++) {
			cin >> favo >> hate;
			if (!channel.count(hate)) {
				channel.emplace(hate, favo);
				visited.emplace(hate, false);
			}
		}
	}

	~Graph() {
		channel.clear();
		visited.clear();
	}
	
	int dfs() {
		int result = 0;
		visited[P] = true;
		if (!channel.count(P)) return 0;
		return dfs(channel[P]);
	}

private:
	int dfs(int n) {
		int change = 1;
		visited[n] = true;

		if (!channel.count(n)) return change;

		if (!visited[channel[n]]) {
			int result = dfs(channel[n]);
			if (result == -1) return -1;
			else return change + result;
		}
		else return -1;
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int N, M, P;
	cin >> N >> M >> P;

	Graph* g = new Graph(N, M, P);

	cout << g->dfs();
}