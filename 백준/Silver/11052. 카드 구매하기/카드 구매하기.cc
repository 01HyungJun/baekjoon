#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int N;

	cin >> N;

	vector<int> card(N + 1, 0);
	vector<int> dp(N + 1, 0);

	for (int i = 1; i <= N; i++) cin >> card[i];

	for (int i = 1; i <= N; i++) {
		dp[i] = max(card[i], dp[i]);
		for (int j = 1; j < i; j++) {
			dp[i] = max(dp[i], dp[i - j] + dp[j]);
			if (i % j == 0) dp[i] = max(dp[i], dp[j] * (i / j));
		}
	}

	cout << dp[N];
}