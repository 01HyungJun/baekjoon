#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int N, L;
	int tape_start, count = 0;
	
	cin >> N >> L;

	vector<int> location(N, 0);
	for (int i = 0; i < N; i++) {
		cin >> location[i];
	}
	sort(location.begin(), location.end());

	tape_start = location[0];
	for (int i = 0; i < N; i++) {
		if ((location[i] - tape_start) >= L) {
			tape_start = location[i];
			count++;
		}
		if (i + 1 == N) {
			count++;
			break;
		}
	}
	cout << count;
}