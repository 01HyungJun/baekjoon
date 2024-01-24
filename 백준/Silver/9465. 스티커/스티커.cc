#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int max_col;
vector<vector<int>> sticker;
vector<vector<int>> dp;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> max_col;
		sticker.resize(2, vector<int>(max_col, 0));
		dp.resize(max_col + 1, vector<int>(3, 0));
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < max_col; k++) {
				cin >> sticker[j][k];
			}
		}
		for (int j = 0; j < max_col; j++) {
			dp[j + 1][0] = max(dp[j + 1][0], max(dp[j][0], max(dp[j][1], dp[j][2])));
			dp[j + 1][1] = max(dp[j + 1][1], max(dp[j][0], dp[j][2]) + sticker[0][j]);
			dp[j + 1][2] = max(dp[j + 1][2], max(dp[j][0], dp[j][1]) + sticker[1][j]);
		}

		cout << max(dp[max_col][0], max(dp[max_col][1], dp[max_col][2])) << "\n";
		vector<vector<int>>().swap(sticker);
		vector<vector<int>>().swap(dp);
	}
}