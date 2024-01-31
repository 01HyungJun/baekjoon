#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int N, K;

	cin >> N >> K;

	vector<vector<int>> dp(N + 1, vector<int>(N + 1, 0));

	dp[0][0] = 1;
	dp[1][0] = 1;
	dp[1][1] = 1;

	for (int i = 2; i <= N; i++) {
		for (int j = 0; j <= i / 2; j++) {
			if (j != 0) {
				dp[i][j] = (dp[i - 1][j - 1] % 10007 + dp[i - 1][j] % 10007) % 10007;
			}
			else {
				dp[i][j] = dp[i - 1][j] % 10007;
			}
			dp[i][i - j] = dp[i][j];
		}
	}

	cout << dp[N][K];
}