#include <iostream>
#include <queue>
#define fastio ios::sync_with_stdio(false), cin,tie(NULL), cout.tie(NULL)
using namespace std;

int N, K, L;
int gameTime = 0;
bool gameEnd = false;
char direction = 'R';
char board[101][101] = { '\0' };
queue <pair<int, int>> snake;
queue <pair<int, char>> changeDirection;

void moveSnake(int x, int y) {
	if (x < 0 || y < 0 || board[x][y] == 'S' || board[x][y] == '#') {
		gameEnd = true;
	}
	else if (board[x][y] == 'A') {
		board[x][y] = 'S';
		snake.push(make_pair(x, y));
	}
	else {
		board[snake.front().first][snake.front().second] = '\0';
		snake.pop();

		board[x][y] = 'S';
		snake.push(make_pair(x, y));
	}
	return;
}

int main() {
	snake.push(make_pair(0, 0));
	board[0][0] = 'S';

	cin >> N;
	for (int i = 0; i < N; i++) {
		board[N][i] = '#';
		board[i][N] = '#';
	}

	cin >> K;
	for (int i = 0; i < K; i++) {
		int row, col;
		cin >> row >> col;
		board[row - 1][col - 1] = 'A';
	}

	cin >> L;
	for (int i = 0; i < L; i++) {
		pair<int, char> cd;
		cin >> cd.first >> cd.second;
		changeDirection.push(cd);
	}
	
	while (gameTime <= 10000 && !gameEnd) {
		if (!changeDirection.empty() && gameTime == changeDirection.front().first) {
			switch (direction) {
			case 'R':
				if (changeDirection.front().second == 'L') direction = 'U';
				else direction = 'D';
				break;
			case 'D':
				if (changeDirection.front().second == 'L') direction = 'R';
				else direction = 'L';
				break;
			case 'L':
				if (changeDirection.front().second == 'L') direction = 'D';
				else direction = 'U';
				break;
			case 'U':
				if (changeDirection.front().second == 'L') direction = 'L';
				else direction = 'R';
				break;
			}
			changeDirection.pop();
		}

		switch (direction) {
		case 'R':
			moveSnake(snake.back().first, snake.back().second + 1);
			break;
		case 'D':
			moveSnake(snake.back().first + 1, snake.back().second);
			break;
		case 'L':
			moveSnake(snake.back().first, snake.back().second - 1);
			break;
		case 'U':
			moveSnake(snake.back().first - 1, snake.back().second);
			break;
		}
		gameTime++;
	}

	cout << gameTime;
}