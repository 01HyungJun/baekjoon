#include <iostream>
#include <set>
#include <math.h>
using namespace std;

void calTriNum(set<int>& triNum) {
	for (int i = 1; i <= (int)sqrt(2000); i++) {
		triNum.insert((i * (i + 1)) / 2);
	}
}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int T, num = 0;
	set<int> triNum;
	calTriNum(triNum);
	cin >> T;
	
	for (int i = 0; i < T; i++) {
		bool flag = false;
		cin >> num;
		for (auto& it : triNum) {
			for (auto& it2 : triNum) {
				if (triNum.end() != triNum.find(num - it - it2)) {
					cout << 1 << "\n";
					flag = true;
					break;
				}
			}
			if (flag) break;
		}
		if (!flag) cout << 0 << "\n";
	}
}