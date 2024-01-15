#include <iostream>
#include <vector>
using namespace std;

int main() {
	int N, K;
	int count = 0;
	
	cin >> N >> K;

	vector<int> Ai(N, 0);

	for (int i = 0; i < N; i++) {
		cin >> Ai[i];
	}

	int i = N - 1;
	while (K > 0) {
		if (K < Ai[i]) {
			i--;
			continue;
		}
		count += (K / Ai[i]);
		K -= (K / Ai[i] * Ai[i]);
		i--;
	}
	cout << count;
}