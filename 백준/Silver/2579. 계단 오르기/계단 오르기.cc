#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {

	int N;
	
	cin >> N;
	vector<int> stairs(N, 0);
	vector<int> dp(N, 0);

	for (int i = 0; i < N; i++) {
		cin >> stairs[i];
	}

	if (N == 1) {
		cout << stairs[0];
		return 0;
	}
	if (N == 2) {
		cout << stairs[0] + stairs[1];
		return 0;
	}

	dp[0] = stairs[0];	// 최대값
	dp[1] = max(stairs[0] + stairs[1], stairs[1]);
	dp[2] = max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
	
	if (N == 3) {
		cout << dp[2];
		return 0;
	}

	for (int i = 3; i < N; i++) {
		dp[i] = stairs[i] + max(dp[i - 2], dp[i - 3] + stairs[i - 1]);
	}

	cout << dp[N - 1] << "\n";

	return 0;
}