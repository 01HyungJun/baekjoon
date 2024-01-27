#include <iostream>
#include <deque>
using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int N;
	cin >> N;

	if (N == 1) {
		cout << 1;
		return 0;
	}

	deque<int> tile(N + 1, 0);

	tile[1] = 1;
	tile[2] = 3;

	for (int i = 3; i <= N; i++) {
		tile[i] = tile[i - 1] + (tile[i - 2] * 2);
		tile[i] %= 10007;
	}

	cout << tile[N];
}