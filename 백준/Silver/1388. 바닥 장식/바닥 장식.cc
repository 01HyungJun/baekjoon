#include <iostream>
using namespace std;

char floor_input[50][51];
bool floor_visited[50][51] = { false, };

void visited(char a, int i, int j) {
    if (a == '-') {
        if (floor_input[i][j] == floor_input[i][j + 1]) {
            floor_visited[i][j + 1] = true;
            visited('-', i, j + 1);
        }
    }
    else {
        if (floor_input[i][j] == floor_input[i + 1][j]) {
            floor_visited[i + 1][j] = true;
            visited('|', i + 1, j);
        }
    }
}

int floor_count(int N, int M) {
    int count = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (floor_visited[i][j]) continue;
            if (floor_input[i][j] == '-') visited('-', i, j);
            else visited('|', i, j);
            floor_visited[i][j] = true;
            count++;
        }
    }
    return count;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;

    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> floor_input[i][j];
        }
    }

    cout << floor_count(N, M);

    return 0;
}