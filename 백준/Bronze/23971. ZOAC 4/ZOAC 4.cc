#include <iostream>

using namespace std;

int main() {
	int H, W, N, M, cnt = 0;
	cin >> H >> W >> N >> M;

	for (int i = 1; i <= H; i += (N + 1)) {
		for (int j = 1; j <= W; j += (M + 1)) {
			cnt++;
		}
	}

	cout << cnt;
}