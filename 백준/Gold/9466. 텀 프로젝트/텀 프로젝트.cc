#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class Graph {
public:
	int numSt, count = 0;

	vector<int> choice;
	vector<bool> visited;
	vector<bool> finished;

	Graph(int n) : numSt(n) {
		choice.resize(numSt + 1, 0);
		visited.resize(numSt + 1, false);
		finished.resize(numSt + 1, false);

		int temp;
		for (int i = 1; i <= numSt; i++) {
			cin >> temp;
			choice[i] = temp;
		}
	}

	~Graph() {
		vector<int>().swap(choice);
		vector<bool>().swap(visited);
		vector<bool>().swap(finished);
	}

	int dfsCycle() {
		for (int i = 1; i <= numSt; i++) {
			if (!visited[i]) dfs(i);
		}
		return numSt - count;
	}

private:
	void dfs(int curr) {
		visited[curr] = true;
		int next = choice[curr];
		if (visited[next]) {
			if (!finished[next]) {
				for (int t = next; t != curr; t = choice[t]) count++;
				count++;
			}
		}
		else dfs(next);
		finished[curr] = true;
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int T, numSt;
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> numSt;
		Graph* g = new Graph(numSt);
		cout << g->dfsCycle() << "\n";
		delete g;
	}
}