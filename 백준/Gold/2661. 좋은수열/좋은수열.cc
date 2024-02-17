#include <iostream>
#include <vector>
using namespace std;

int N;
bool flag = false;
string arr = "";

void backtrack(int len, int prev) {
	if (len == N) {
		cout << arr;
		flag = true;
		return;
	}

	for (int i = 1; i <= 3; i++) {
		if (i == prev) continue;
		arr.push_back(i + '0');

		int range = len % 2 == 0 ? len / 2 : (len / 2) + 1;
		bool flag3 = false;
		for (int i = 2; i <= range; i++) {
			bool flag2 = false;
			for (int j = 0; j < i; j++) {
				if (arr[len - j] != arr[len - j - i]) {
					flag2 = true;
					break;
				}
			}
			if (!flag2) {
				flag3 = true;
				break;
			}
		}
		if (flag3) {
			arr.pop_back();
			continue;
		}
		else {
			backtrack(len + 1, i);
			if (flag) return;
			arr.pop_back();
		}
	}
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> N;

	arr.push_back('1');

	backtrack(1, 1);
}