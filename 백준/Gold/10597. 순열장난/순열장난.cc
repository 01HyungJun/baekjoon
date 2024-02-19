#include <iostream>

using namespace std;

string s;
bool isEnd = false;
bool numbers[51];
int printNum[51] = { 0 };

void backtrack(int curr, int numCount) {
    if (curr >= s.length()) {
        for (int i = 1; i <= numCount; i++) {
            if (!numbers[i]) return;
        }

        for (int i = 0; i < numCount; i++) {
            cout << printNum[i] << " ";
        }
        isEnd = true;
        return;
    }

    int temp = s[curr] - '0';
    int next = curr + 1 < s.length() ? s[curr + 1] - '0' : -1;
    
    if (temp <= 50 && !numbers[temp] && next != 0) {
        numbers[temp] = true;
        printNum[numCount] = temp;
        backtrack(curr + 1, numCount + 1);
        if (isEnd) return;

        numbers[temp] = false;
        printNum[numCount] = 0;
    }

    if (next != -1) {
        temp = (temp * 10) + next;
        if (temp <= 50 && !numbers[temp]) {
            numbers[temp] = true;
            printNum[numCount] = temp;
            backtrack(curr + 2, numCount + 1);
            if (isEnd) return;

            numbers[temp] = false;
            printNum[numCount] = 0;
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> s;

    backtrack(0, 0);
    cout << "\n";

    return 0;
}