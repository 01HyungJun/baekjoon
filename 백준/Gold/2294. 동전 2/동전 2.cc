#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, K;
vector<int> coin;
vector<vector<int>> dp;

int count_coin(int n, int k) {
	if (n == coin.size()) {
		if (k == 0) return 0;
		else return 100000;
	}
	if (dp[n][k] != -1) return dp[n][k];

	int result = count_coin(n + 1, k);
	if (k >= coin[n]) result = min(result, count_coin(n, k - coin[n]) + 1);

	dp[n][k] = result;
	return result;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> N >> K;

	dp.resize(N, vector<int>(K + 1, -1));

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

	int output = count_coin(0, K);
	if (output != 100000) cout << output;
	else cout << -1;
}