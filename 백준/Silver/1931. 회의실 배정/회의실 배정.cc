#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, int>& a, pair<int, int>& b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}
	return a.second < b.second;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int N, count = 0;
	int start, end;
	
	cin >> N;

	vector<pair<int, int>> schedule;

	for (int i = 0; i < N; i++) {
		cin >> start >> end;
		schedule.emplace_back(start, end);
	}

	sort(schedule.begin(), schedule.end(), compare);

	end = 0;
	for (int i = 0; i < N; i++) {
		if (end > schedule[i].first) continue;
		end = schedule[i].second;
		count++;
	}

	cout << count;
}