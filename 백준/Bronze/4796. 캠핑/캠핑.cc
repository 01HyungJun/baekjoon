#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int L, P, V;
	int result, count = 1;

	while (1) {
		cin >> L >> P >> V;

		if (L == 0 || P == 0 || V == 0) break;

		result = V / P * L;
		if (V % P < L) result += V % P;
		else result += L;

		cout << "Case " << count << ": " << result << "\n";
		count++;
	}
}