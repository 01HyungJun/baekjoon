#include <iostream>
#include <vector>
#include <deque>
using namespace std;

int N, cnt = 0;
int dx[5] = { 1, 0, -1, 1, -1};
int dy[5] = { 1, 1, 1, 0, 0};
vector<vector<bool>> board;
vector<vector<bool>> queen;

void backtrack(int x, int y, int numQueen) {
	if (numQueen == N) {
		cnt++;
		return;
	}

	board[y][x] = true;
	queen[y][x] = true;

	deque<pair<int, int>> record(0);

	for (int i = 1; i < N; i++) {
		for (int j = 0; j < 5; j++) {
			int ny = y + (dy[j] * i);
			int nx = x + (dx[j] * i);

			if (nx < 0 || nx >= N || ny >= N || queen[ny][nx]) continue;
			queen[ny][nx] = true;
			record.emplace_back(nx, ny);
		}
	}
		for (int i = 0; i < N; i++) {
			if (!queen[y + 1][i]) backtrack(i, y + 1, numQueen + 1);
		}

	board[y][x] = false;
	queen[y][x] = false;

	int size = record.size();
	for (int i = 0; i < size; i++) {
		int ny = record.front().second;
		int nx = record.front().first;
		queen[ny][nx] = false;
		record.pop_front();
	}
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> N;

	board.resize(N, vector<bool>(N, false));
	queen.resize(N, vector<bool>(N, false));

	for (int i = 0; i < N; i++) {
		backtrack(i, 0, 1);
	}

	cout << cnt;
}