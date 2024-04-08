#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <climits> // <climits> 헤더 파일 추가

using namespace std;

int calculateGiftIndex(int given, int received) {
    return given - received;
}

int solution(vector<string> friends, vector<string> gifts) {
    unordered_map<string, int> giftCounts;
    unordered_map<string, int> givenCounts;
    unordered_map<string, int> receivedCounts;

    // 각 친구들의 선물 횟수를 계산합니다.
    for (string gift : gifts) {
        string giver = gift.substr(0, gift.find_first_of("->"));
        string receiver = gift.substr(gift.find_first_of(">") + 1);

        givenCounts[giver]++;
        receivedCounts[receiver]++;
    }

    // 각 친구들의 선물 지수를 계산합니다.
    for (string friendName : friends) {
        int given = givenCounts[friendName];
        int received = receivedCounts[friendName];
        giftCounts[friendName] = calculateGiftIndex(given, received);
    }

    // 가장 많은 선물을 받을 친구의 선물 지수를 찾습니다.
    int maxGifts = INT_MIN;
    for (auto it : giftCounts) {
        maxGifts = max(maxGifts, it.second);
    }

    // 선물을 가장 많이 받을 친구의 선물 수를 반환합니다.
    return maxGifts > 0 ? maxGifts : 0;
}

int main() {
    vector<string> friends = {"A", "B", "C"};
    vector<string> gifts = {"A->B", "B->A", "B->C", "C->A", "C->B", "C->A"};

    int result = solution(friends, gifts);
    cout << "다음 달에 가장 많은 선물을 받을 친구가 받을 선물의 수: " << result << endl;

    return 0;
}
