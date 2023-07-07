#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
	int n, m, cntWB, cntBW, min = 100;
	string WB[8] = {
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW"
	};
	string BW[8] = {
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB"
	};

	cin >> n >> m;

	vector<string> board(n, "");

	for (int i = 0; i < n; i++) {
		cin >> board[i];
	}

	for (int i = 0; i < n - 7; i++) {
		for (int j = 0; j < m - 7; j++) {
			cntWB = 0;
			cntBW = 0;
			for (int k = i; k < i + 8; k++) {
				for (int l = j; l < j + 8; l++) {
					if (board[k][l] != WB[k - i][l - j]) cntWB++;
					if (board[k][l] != BW[k - i][l - j]) cntBW++;
				}
			}
			if (cntWB < min) min = cntWB;
			if (cntBW < min) min = cntBW;
		}
	}

	cout << min << '\n';
}