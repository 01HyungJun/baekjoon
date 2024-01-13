#include <iostream>
#include <vector>
using namespace std;

bool checkStrikeAndBall(int input, int gen, int strike, int ball) {
	vector<int> inputNum(3, 0);
	vector<int> genNum(3, 0);
	int st = 0, ba = 0;
	int i = 0;
	while (i < 3) {
		inputNum[i] = input % 10;
		genNum[i] = gen % 10;
		input /= 10;
		gen /= 10;
		i++;
	}

	for (i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (inputNum[i] == genNum[j]) {
				if (i == j) st++;
				else ba++;
			}
		}
	}

	if (strike != st || ball != ba) return 1;
	else return 0;
}

bool isZeroOrDuplicate(int gen) {
	int digit;
	bool digitCount[10] = { false };
	while (gen > 0) {
		digit = gen % 10;
		if (digit == 0) return 1;
		if (digitCount[digit]) return 1;
		digitCount[digit] = true;
		gen /= 10;
	}
	return 0;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int N;
	int num, strike, ball;
	int cnt = 0;
	vector<bool> numArr(1000, true);

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> num >> strike >> ball;
		for (int i = 123; i <= 987; i++) {
			if (isZeroOrDuplicate(i)) {
				numArr[i] = false;
				continue;
			}
			if (checkStrikeAndBall(num, i, strike, ball)) numArr[i] = false;
		}
	}

	for (int i = 123; i <= 987; i++) {
		if (numArr[i]) cnt++;
	}
	cout << cnt;
}