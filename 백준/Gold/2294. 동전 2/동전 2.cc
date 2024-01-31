#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, K;
vector<int> coin;
vector<vector<int>> dp;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> N >> K;

	dp.resize(N + 1, vector<int>(K + 1, 100000));

	int input;
	for (int i = 0; i < N; i++) {
		cin >> input;
		bool flag = false;
		for (int j = 0; j < coin.size(); j++) {
			if (coin[j] == input) {
				flag = true;
				break;
			}
		}
		if (flag) continue;
		coin.push_back(input);
	}

	sort(coin.begin(), coin.end());


	for (int i = 0; i < N; i++) {
		dp[i][0] = 0;
		for (int j = 0; j <= K; j++) {
			dp[i + 1][j] = dp[i][j];
			int temp = j + coin[i];
			if (temp <= K) dp[i][temp] = min(dp[i][temp], dp[i][j] + 1);
		}
	}

	if (dp[N - 1][K] == 100000) cout << -1;
	else cout << dp[N - 1][K];
}