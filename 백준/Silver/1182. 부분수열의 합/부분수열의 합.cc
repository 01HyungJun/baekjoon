#include <iostream>
#include <vector>
#include <algorithm>
#define fastio ios::sync_with_stdio(false), cin,tie(NULL), cout.tie(NULL)
using namespace std;

int main() {
	int N, S;
	int total = 0, count = 0;
	
	cin >> N >> S;

	vector<int> arr(N, 0);

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	for (int i = 1; i <= N; i++) {
		vector<bool> subArr(N - i, false);
		subArr.insert(subArr.end(), i, true);
		do {
			total = 0;
			for (int j = 0; j < N; j++) {
				if (subArr[j]) total += arr[j];
			}
			if (total == S) count++;
		} while (next_permutation(subArr.begin(), subArr.end()));
	}

	cout << count;
}