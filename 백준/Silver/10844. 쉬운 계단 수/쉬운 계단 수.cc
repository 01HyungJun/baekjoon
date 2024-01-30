#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int N;
	cin >> N;
	
	vector<vector<long long>> dp(N + 1, vector<long long>(10, 0));

	vector<long long> first(10, 1);
	dp[1] = first;
	dp[1][0] = 0;

	for (int n = 1; n < N; n++) {
		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				dp[n + 1][i] = dp[n][i + 1];
			}
			else if (i == 9) {
				dp[n + 1][i] = dp[n][i - 1];
			}
			else {
				dp[n + 1][i] = dp[n][i - 1] + dp[n][i + 1];
			}
			dp[n + 1][i] %= 1000000000;
		}
	}

	int result = 0;
	for (int i = 0; i < 10; i++) {
		result = (result % 1000000000 + dp[N][i] % 1000000000) % 1000000000;
	}

	cout << result;
}