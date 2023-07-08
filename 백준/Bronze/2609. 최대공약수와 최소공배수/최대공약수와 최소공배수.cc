#include <iostream>

using namespace std;

int main() {	// 최대공약수(GCM), 최소공배수(LCM) = 유클리드 호제법
	int n, m, f, s, temp;

	cin >> n >> m;

	if (m > n) swap(n, m);
	f = n;
	s = m;

	while (1) {
		if (f % s == 0) {
			cout << s << '\n';
			break;
		}
		else {
			temp = f % s;
			f = s;
			s = temp;
		}
	}

	cout << n * m / s << '\n';
}