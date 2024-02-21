#include <iostream>
#include <deque>
using namespace std;

int main() {
	string code;
	cin >> code;

	int N;
	cin >> N;

	deque<string> word(N, "");
	for (int i = 0; i < N; i++) {
		cin >> word[i];
	}
	
	for (int i = 0; i < 26; i++) {
		for (int j = 0; j < code.length(); j++) {
			if(code[j] != 'z') code[j]++;
			else code[j] = 'a';
		}
		for (int k = 0; k < word.size(); k++) {
			if (code.find(word[k]) != string::npos) {
				cout << code;
				return 0;
			}
		}
	}

	return 0;
}