#include <iostream>
#include <vector>
#define fastio ios::sync_with_stdio(false), cin,tie(NULL), cout.tie(NULL)
using namespace std;

int main() {
	int N, B, C;
	long long count = 0;
	vector<int> examinee;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		examinee.push_back(num);
	}
	cin >> B >> C;

	for (int i = 0; i < N; i++) {
		examinee[i] -= B;
		count++;
		if (examinee[i] > 0) {
			count += (examinee[i] / C);
			if ((examinee[i] % C) > 0) count++;
		}
	}
	
	cout << count;
}