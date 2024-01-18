#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;

deque<long long> arr;

long long maximum(int start, int end) {
	if (start == end) return arr[start] * arr[start];
	if (start + 1 == end) {
		if (arr[start] > arr[end]) {
			return max((arr[start] + arr[end]) * arr[end], arr[start] * arr[start]);
		}
		else {
			return max((arr[start] + arr[end]) * arr[start], arr[end] * arr[end]);
		}

	}
	
	int mid = (start + end) / 2;
	long long result = max(maximum(start, mid), maximum(mid, end));

	long long minimum = arr[mid];
	long long total = arr[mid];
	int right = mid, left = mid;

	while (right - left < end - start) {
		int p, q;
		if (left > start) p = arr[left - 1];
		else p = -1;

		if (right < end) q = arr[right + 1];
		else q = -1;

		if (p >= q) {
			total += p;
			minimum = min(minimum, (long long)p);
			left--;
					}
		else {
			total += q;
			minimum = min(minimum, (long long)q);
			right++;
		}

		result = max(result, (total * minimum));
	}

	return result;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int N, input;

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> input;
		arr.push_back(input);
	}

	cout << maximum(0, N - 1);
}