#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int N;

	cin >> N;

	vector<int> tile(N+1, 0);

	tile[1] = 1;
	tile[2] = 2;

	for (int i = 3; i <= N; i++) {
		tile[i] = tile[i - 1] + tile[i - 2];
		tile[i] %= 15746;
	}

	cout << tile[N];
}