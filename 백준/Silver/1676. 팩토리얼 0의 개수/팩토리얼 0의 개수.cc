#include <iostream>

using namespace std;

int main() {
	int n, cfive = 0;
	cin >> n;

	for (int i = n; i > 0; i--) {
		n = i;
		while (n % 5 == 0) {
			n /= 5;
			cfive++;
		}
	}

	cout << cfive << '\n';
}