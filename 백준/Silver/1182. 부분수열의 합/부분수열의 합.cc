#include <iostream>
#include <deque>
using namespace std;

int N, S;
int currSum = 0, cnt = 0;
deque<int> d;

void dfs(int curr) {
    if (curr == N) return;

    if (currSum + d[curr] == S) cnt++;

    dfs(curr + 1);

    currSum += d[curr];
    dfs(curr + 1);

    currSum -= d[curr];
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    
    cin >> N >> S;

    d.resize(N);

    for (int i = 0; i < N; i++) {
        cin >> d[i];
    }

    dfs(0);

    cout << cnt;

    return 0;
}
