#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Graph {
public:
	int A, B;

	vector<pair<bool, int>> visited;
	vector<char> op;
	vector<char> result;
	queue<int> q;

	Graph(int a, int b) : A(a), B(b) {
		visited.resize(10000, pair<bool, int>(false, -1));
		op.resize(10000, 'N');
	}

	~Graph() {
		vector<pair<bool, int>>().swap(visited);
		vector<char>().swap(op);
		queue<int>().swap(q);
	}

	vector<int> digit(int cx) {
		vector<int> numbers(4, 0);
		int num = cx;
		int i = 3;
		while (num > 0) {
			numbers[i] = num % 10;
			num /= 10;
			i--;
		}
		return numbers;
	}

	vector<char> bfsOP() {
		visited[A].first = true;
		visited[A].second = -2;
		q.push(A);
		while (!q.empty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cx = q.front();
				if (cx == B) {	// 탈출
					char temp = op[cx];
					int before = visited[cx].second;
					while (before != -2) {
						result.push_back(temp);
						cx = before;
						before = visited[cx].second;
						temp = op[cx];
					}
					return result;
				}
				q.pop();

				int nx;
				char oper;
				vector<int> numbers = digit(cx);
				for (int j = 0; j < 4; j++) {
					switch (j) {
					case 0:
						nx = (cx * 2) % 10000;
						oper = 'D';
						break;
					case 1:
						if (cx != 0) nx = cx - 1;
						else nx = 9999;
						oper = 'S';
						break;
					case 2:
						nx = numbers[1] * 1000 + numbers[2] * 100 + numbers[3] * 10 + numbers[0];
						oper = 'L';
						break;
					case 3:
						nx = numbers[3] * 1000 + numbers[0] * 100 + numbers[1] * 10 + numbers[2];
						oper = 'R';
						break;
					}

					if (!visited[nx].first) {
						visited[nx].first = true;
						visited[nx].second = cx;
						op[nx] = oper;
						q.push(nx);
					}
				}
			}
		}
	}

};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int T, A, B; 
	vector<char> result;

	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> A >> B;
		//출력 뒤집어서
		Graph* g = new Graph(A, B);
		result = g->bfsOP();
		for (int i = result.size() - 1; i >= 0; i--) {
			cout << result[i];
		}
		cout << "\n";
		delete g;
	}
}