#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;

int L, C;
int cnt = 0;
string output;
deque<char> password;
deque<bool> alphabet(26, false);

void backtrack(int curr, int prev, int consonant, int vowel) {
    if (curr == L) {
        if (consonant >= 2 && vowel >= 1) cout << output << "\n";
        return;
    }

    for (int i = prev + 1; i < C; i++) {
        output[curr] = password[i];
        backtrack(curr + 1, i, consonant + !alphabet[password[i] - 'a'], vowel + alphabet[password[i] - 'a']);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> L >> C;

    password.resize(C);

    for (int i = 0; i < C; i++) {
        cin >> password[i];
    }

    output.resize(L);
    sort(password.begin(), password.end());
    alphabet[0] = alphabet[4] = alphabet[8] = alphabet[14] = alphabet[20] = true;

    backtrack(0, -1, 0, 0);

    return 0;
}