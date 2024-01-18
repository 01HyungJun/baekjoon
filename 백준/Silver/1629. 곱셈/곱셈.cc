#include <iostream>

using namespace std;

long long power(long long a, long long b, long long c) {
	if (b == 1) return a % c;

	long long result = power(a, b / 2, c);

	if (b % 2 == 0) return (result * result) % c;
	else return ((result * result) % c) * (a % c) % c;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	long long A, B, C;

	cin >> A >> B >> C;

	cout << power(A, B, C);
}