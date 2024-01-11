#include <iostream>
#define fastio ios::sync_with_stdio(false), cin,tie(NULL), cout.tie(NULL)
using namespace std;

int countRow(char board[][50], int i, int j, int N) {
	int count = 1;
	if ((j != (N - 1)) && (board[i][j] == board[i][j + 1])) {
		return count + countRow(board, i, j + 1, N);
	}
	return count;
}

int countCol(char board[][50], int i, int j, int N) {
	int count = 1;
	if ((i != (N - 1)) && (board[i][j] == board[i + 1][j])) {
		return count + countCol(board, i + 1, j, N);
	}
	return count;
}

int countBoard(char board[][50], int N) {
	int count = 0;
	int cntR, cntL;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cntR = countRow(board, i, j, N);
			if (cntR == N) return N; 
			cntL = countCol(board, i, j, N);
			if (cntL == N) return N;
			if (cntR > count) count = cntR;
			if (cntL > count) count = cntL;
		}
	}
	return count;
}

int main() {
	int N;
	int temp, count = 0;
	char board[50][50];

	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if ((j != (N - 1)) && (board[i][j] != board[i][j + 1])) {
				swap(board[i][j], board[i][j + 1]);
				temp = countBoard(board, N);
				if (temp > count) count = temp;
				swap(board[i][j], board[i][j + 1]);
			}
			if ((i != (N - 1)) && (board[i][j] != board[i + 1][j])) {
				swap(board[i][j], board[i + 1][j]);
				temp = countBoard(board, N);
				if (temp > count) count = temp;
				swap(board[i][j], board[i + 1][j]);
			}
		}
		if (count == N) break;
	}

	cout << count;
}