#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int R, C;
int cnt = 1;
vector<vector<char>> board;
vector<vector<bool>> visited;
vector<bool> used(26, false);

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

void backtrack(int x, int y, int dist) {
    cnt = max(dist, cnt);
    visited[y][x] = true;
    used[board[y][x] - 'A'] = true;
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx]) continue;
        if (!used[board[ny][nx] - 'A']) backtrack(nx, ny, dist + 1);
    }

    visited[y][x] = false;
    used[board[y][x] - 'A'] = false;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> R >> C;

    board.resize(R, vector<char>(C));
    visited.resize(R, vector<bool>(C, false));

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> board[i][j];
        }
    }

    backtrack(0, 0, 1);
    cout << cnt;

    return 0;
}