#include <iostream>
#include <string>
using namespace std;

int main() {
	bool flag = 1;
	int n, sum = 0;
	string s;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		sum = 0;
		s = to_string(i);
		for (int j = 0; j < s.length(); j++) {
			sum += (int)(s[j] - 48);
		}
		if (n == (sum + i)) {
			cout << i << '\n';
			flag = 0;
			break;
		}
	}
	if (flag) cout << 0 << '\n';
}