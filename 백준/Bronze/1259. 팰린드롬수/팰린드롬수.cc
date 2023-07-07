#include <iostream>
#include <string>
#define fastio ios::sync_with_stdio(false), cin,tie(NULL), cout.tie(NULL)

using namespace std;

int main() {
	int num;
	bool flag = true;
	string s;

	while (1) {
		flag = true;
		cin >> num;
		s = to_string(num);
		if (num == 0) break;
		if (s.length() == 1) {
			cout << "yes\n";
			continue;
		}
		for (int i = 0; i < s.length() / 2; i++) {
			if (s[i] != s[s.length() - i - 1]) {
				flag = false;
				cout << "no\n";
				break;
			}
		}
		if (flag) cout << "yes\n";
	}
}