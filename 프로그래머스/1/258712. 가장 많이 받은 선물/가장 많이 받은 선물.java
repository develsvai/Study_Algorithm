import java.util.*;

class Solution {
     
        
        public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] count = new int[friends.length];
        int[][] table = new int[friends.length][friends.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        // 맵 만들기
        for(int i=0; i<friends.length; ++i) {
            map.put(friends[i], i);
        }
        
        // 초기화
        for(int i=0; i<friends.length; ++i) {
            for(int j=0; j<friends.length; ++j) {
                table[i][j] = 0;
            }
            count[i] = 0;
        }
        
        // 선물 테이블 만들기
        for(int i=0; i<gifts.length; ++i) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            int giver = map.get(st.nextToken());
            int taker = map.get(st.nextToken());
            
            table[giver][taker] += 1;
        }
        
        
        // 1을 이중 포문으로 돌기
        for(int i=0; i<friends.length; ++i) {
            for(int j=0; j<friends.length; ++j) {
                // if(i==j) continue;
                if(i >= j) continue; // 중복
                
                int i_give = table[i][j], j_give = table[j][i];
                if(i_give > j_give) {
                    count[i] += 1;
                } else if(i_give < j_give) {
                    count[j] += 1;
                } else { // 같음. 선물 지수 구하기
                    int i_score = 0;
                    int give = 0, take = 0;
                    for(int k=0; k<friends.length; ++k) {
                        give += table[i][k];
                        take += table[k][i];
                    }
                    i_score = give - take;
                    
                    int j_score = 0;
                    give = 0; take = 0;
                    for(int k=0; k<friends.length; ++k) {
                        give += table[j][k];
                        take += table[k][j];
                    }
                    j_score = give - take;
                    
                    if(i_score > j_score) {
                        count[i] += 1;
                    } else if(i_score < j_score) {
                        count[j] += 1;
                    }
                }
            }
        }
        
        // 가장 큰 값 구하기
        answer = count[0];
        for(int cnt : count) {
            if(answer < cnt) answer = cnt;
        }
        return answer;
    }

        
    
}




/**
조건

두사람이 선물을 주고받은 기록이 있다면 , 이번 달까지 두사람 사이에 더 많은 선물을 준 사람이 다음달에 선물을 하나 받는다 .
두사람이 선물을 주고 받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 작은 사람에게 선물을 하나 받는다.
배열

Friends -> 친구들의 이름을 담은 1차원 배열 gifts -> 이번달까지 친구들이주고받은 선물 기록 

friend <= 50
gifts <= 10000

1. 각 인원 별 준 선물과 받은 선물 의 수 를 추합
누굴 몇개 주었는지, 누구한데 몇개를 받았는지를 알아야함 

2. 위의 값을 기준으로 선물 지수를 계산 

3. 1,2 과정을 모든 인원에 대하여 실행 

4. 한명 씩 다른인원 들과 비교하여 받을 선물의 수를 계산 하여 배열에 저장 

5. 해당 배열에서 가장 큰수 를 반환 

즉 각 친구들이 다음달에 받을 선물 개수를 구해서 그중에 가장 큰거 리턴 함.


**/