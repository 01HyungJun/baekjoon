#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int max_col;
vector<vector<int>> sticker;
vector<vector<int>> dp;

int max_sticker(int cols, int status) {
	if (cols == max_col) return 0;
	if (dp[cols][status] != -1) return dp[cols][status];

	int result = max_sticker(cols + 1, 0);
	if (status != 1) result = max(result, max_sticker(cols + 1, 1) + sticker[0][cols]);
	if (status != 2) result = max(result, max_sticker(cols + 1, 2) + sticker[1][cols]);

	dp[cols][status] = result;
	return result;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> max_col;
		sticker.resize(2, vector<int>(max_col, -1));
		dp.resize(max_col, vector<int>(3, -1));
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < max_col; k++) {
				cin >> sticker[j][k];
			}
		}
		cout << max_sticker(0, 0) << "\n";
		vector<vector<int>>().swap(sticker);
		vector<vector<int>>().swap(dp);
		max_col = 0;
	}
}