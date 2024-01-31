#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int N, K, maxV;
	cin >> N >> K;

	vector<vector<int>> package(N, vector<int>(2, -1));
	vector<vector<int>> dp(N + 1, vector<int>(K + 1, 0));

	for (int i = 0; i < N; i++) {
		cin >> package[i][0] >> package[i][1];
	}

	for (int i = 0; i < N; i++) {	// 물건 종류
		for (int j = 0; j <= K; j++) {	// 물건 가치
			dp[i + 1][j] = max(dp[i + 1][j], dp[i][j]);
			int temp = j + package[i][0];
			if (temp <= K) dp[i + 1][temp] = max(dp[i][temp], dp[i][j] + package[i][1]);
		}
	}

	cout << dp[N][K];
}