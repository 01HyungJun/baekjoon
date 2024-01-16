#include <iostream>
#include <deque>
#include <map>
#include <algorithm>
using namespace std;

bool compare(pair<int, int>& a, pair<int, int>& b) {
	if (a.first == b.first) return a.second < b.second;
	return a.first < b.first;
}

bool compareLowerBound(const int& a, const pair<int, int>& b) {
	return b.first < a;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int N, start, end;
	int count = 0;

	cin >> N;

	deque<pair<int, int>> schedule;
	map<int, int> endTime;

	for (int i = 0; i < N; i++) {
		cin >> start >> end;
		schedule.emplace_back(start, end);
	}

	sort(schedule.begin(), schedule.end(), compare);

	endTime[schedule[0].second]++;
	schedule.pop_front();
	count++;

	while (!schedule.empty()) {
		auto it = endTime.upper_bound(schedule[0].first);
		if (it == endTime.begin()) {
			if (it->first == schedule[0].first) {
				if (--endTime[it->first] == 0) endTime.erase(it);
			}
			else {
				count++;
			}
		}
		else {
			it--;
			if (--endTime[it->first] == 0) endTime.erase(it);
		}
		endTime[schedule[0].second]++;
		schedule.pop_front();
	}

	cout << count;
}

// while문에서 하나씩 처리하므로 N
// map에서 upper_bount 처리 시간 logN
// vector의 erase를 사용하면 시간복잡도는 O(N)이기 때문에 N^2logN이 되지만
// deque의 pop_front를 사용하면 O(1)이기 때문에 NlogN으로 만들수 있다.