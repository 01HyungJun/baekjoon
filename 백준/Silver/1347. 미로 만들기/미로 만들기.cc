#include <iostream>
#include <vector>
#include <deque>
using namespace std;

int direct = 0;	// 0 : S, 1 : W, 2 : N, 3 : E
int max_x = 1, max_y = 1;
int cx = 0, cy = 0;
vector<pair<int, int>> way = { {0, 1}, {-1, 0}, {0, -1}, {1, 0} };

void change_direction(char dir) {
	if (dir == 'R') {
		if (direct == 0) direct = 1;
		else if (direct == 1) direct = 2;
		else if (direct == 2) direct = 3;
		else direct = 0;
	}
	else {
		if (direct == 0) direct = 3;
		else if (direct == 3) direct = 2;
		else if (direct == 2) direct = 1;
		else direct = 0;
	}
}

int main() {
	int N;
	cin >> N;

	
	deque<deque<bool>> map(1, deque<bool>(1, true));
	vector<char> record(N, 0);
	for (int i = 0; i < N; i++) {
		cin >> record[i];
	}

	for (int i = 0; i < N; i++) {
		switch (record[i]) {
		case 'L':
			change_direction('L');
			break;

		case 'R':
			change_direction('R');
			break;

		case 'F':
			if (direct == 0) {
				if (cy + way[direct].second >= max_y) {
					max_y++;
					cy++;
					map.push_back(deque<bool>(max_x, false));
					map[cy][cx] = true;
				}
				else {
					cy++;
					map[cy][cx] = true;
				}
			}
			else if (direct == 1) {
				if (cx + way[direct].first < 0) {
					max_x++;
					for (int i = 0; i < map.size(); i++) {
						map[i].push_front(false);
					}
					map[cy][cx] = true;
				}
				else {
					cx--;
					map[cy][cx] = true;
				}
			}
			else if (direct == 2) {
				if (cy + way[direct].second < 0) {
					max_y++;
					map.push_front(deque<bool>(max_x, false));
					map[cy][cx] = true;
				}
				else {
					cy--;
					map[cy][cx] = true;
				}
			}
			else {
				if (cx + way[direct].first >= max_x) {
					max_x++;
					cx++;
					for (int i = 0; i < map.size(); i++) {
						map[i].push_back(false);
					}
					map[cy][cx] = true;
				}
				else {
					cx++;
					map[cy][cx] = true;
				}
			}

			break;
		}
	}

	for (int i = 0; i < max_y; i++) {
		for (int j = 0; j < max_x; j++) {
			if (map[i][j]) cout << '.';
			else cout << '#';
		}
		cout << "\n";
	}
}