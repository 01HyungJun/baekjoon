#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class Graph {
public:
	int N;

	vector<vector<bool>> apt;
	vector<vector<bool>> visited;
	vector<int> count;

	Graph(int n) : N(n) {
		apt.resize(N + 2, vector<bool>(N + 2, false));
		visited.resize(N + 2, vector<bool>(N + 2, false));

		string temp;
		for (int i = 1; i <= N; i++) {
			getline(cin, temp);
			for (int j = 1; j <= N; j++) {
				if (temp[j - 1] == '0') apt[i][j] = false;
				else apt[i][j] = true;
			}
		}
	}

	~Graph() {
		vector<vector<bool>>().swap(apt);
		vector<vector<bool>>().swap(visited);
		vector<int>().swap(count);
	}

	int dfs() {
		int component = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (apt[i][j] && !visited[i][j]) {
					count.push_back(dfs(i, j));
					component++;
				}
			}
		}
		return component;
	}

	void sortCount() {
		sort(count.begin(), count.end());
	}

private:
	int dfs(int r, int c) {
		int cnt = 1;
		visited[r][c] = true;
		if (apt[r][c + 1] && !visited[r][c + 1]) cnt += dfs(r, c + 1);
		if (apt[r + 1][c] && !visited[r + 1][c]) cnt += dfs(r + 1, c);
		if (apt[r][c - 1] && !visited[r][c - 1]) cnt += dfs(r, c - 1);
		if (apt[r - 1][c] && !visited[r - 1][c]) cnt += dfs(r - 1, c);
		return cnt;
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	int N;
	cin >> N;
	cin.ignore();

	Graph* g = new Graph(N);
	cout << g->dfs() << "\n";
	g->sortCount();

	for (int& c : g->count) {
		cout << c << "\n";
	}
}