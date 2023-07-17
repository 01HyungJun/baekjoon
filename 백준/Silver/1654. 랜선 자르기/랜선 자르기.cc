#include <iostream>
#include <vector>
using namespace std;

int bi_search(vector<int> &arr, int n, long long low, long long high) {
	int sum = 0;
	long long mid = (low + high) / 2;
	for (int i = 0; i < arr.size(); i++) {
		sum += (arr[i] / mid);
	}
	if (low > high) return mid;
	if (sum >= n) return bi_search(arr, n, mid + 1, high);
	if (sum < n) return bi_search(arr, n, low, mid - 1);
}

int main() {
	int k, n, result;
	long long low = 1, high = 0;
	
	cin >> k >> n;
	vector<int> vec(k, 0);

	for (int i = 0; i < k; i++) {
		cin >> vec[i];
		if (vec[i] > high) high = vec[i];
	}

	result = bi_search(vec, n, low, high);

	cout << result << '\n';
}