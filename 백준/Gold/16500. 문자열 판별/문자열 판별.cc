#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	string s;
	int N;
	cin >> s;
	cin >> N;

	vector<bool> dp(s.length() + 1, false);
	vector<string> A;
	string temp;
	for (int i = 0; i < N; i++) {
		cin >> temp;
		A.push_back(temp);
	}

	int found = 0;
	dp[0] = true;
	for (int j = 0; j < s.length(); j++) {
		if (dp[j] == true) {
			for (int i = 0; i < N; i++) {
				found = s.find(A[i], j);
				if (found == j) dp[found + A[i].length()] = true;
			}
		}
	}
	
	if (dp[s.length()]) cout << 1;
	else cout << 0;
}