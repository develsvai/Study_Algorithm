class Solution {
    public int solution(int n) {
        String str = "";

        while (n != 0) {
            str += n % 3; //10진을 3진으로 변환
            n /= 3; // 3으로 나누어 수를 뒤집음
        }
        
        return Integer.parseInt(str, 3); //10진으로 반환
    }
}
