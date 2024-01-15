#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int total = 0;
	vector<int> D(11, 0);
	vector<int> V(11, 0);

	for (int i = 0; i < 11; i++) {
		cin >> D[i] >> V[i];
	}

	sort(D.begin(), D.end());

	for (int i = 0; i < 11; i++) {
		total += D[i];
		D[i] = total;
	}

	total = 0;

	for (int i = 0; i < 11; i++) {
		total += D[i];
		total += (V[i] * 20);
	}

	cout << total;
}