#include <iostream>
#include <deque>
#include <unordered_set>
#include <unordered_map>
using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int N, K, max, max_name, count = 0;

	cin >> N >> K;

	deque<int> order(K, 0);
	unordered_map<int, int> total_use;
	unordered_set<int> multitab;

	for (int i = 0; i < K; i++) {
		cin >> order[i];
		total_use[order[i]]++;
	}

	for (int i = 0; i < K; i++) {
		total_use[order[i]]--;
		if ((multitab.size() < N) && multitab.find(order[i]) == multitab.end()) {
			multitab.insert(order[i]);
			continue;
		}
		if (multitab.find(order[i]) != multitab.end()) {
			continue;
		}

		
		bool flag = true;
		for (auto& it : multitab) {
			if (total_use[it] == 0) {
				multitab.erase(it);
				flag = false;
				break;
			}
		}

		if (flag) {
			max = 0;
			max_name = 0;
			for (auto& it : multitab) {
				for (int j = i + 1; j < K; j++) {
					if (it == order[j]) {
						if (max < j) {
							max = j;
							max_name = order[j];
						}
						break;
					}
				}
			}
			multitab.erase(max_name);
		}
		
		multitab.insert(order[i]);
		count++;
	}

	cout << count;
}