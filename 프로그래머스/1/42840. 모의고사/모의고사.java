import java.util.*;
class Solution {
   public int[] solution(int[] answers) {
        int[] answer;

        int[] no1 = {1, 2, 3, 4, 5};
        int[] no2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] no3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == no1[i % no1.length]) {
                score[0]++;
            }
            if (answers[i] == no2[i % no2.length]) {
                score[1]++;
            }
            if (answers[i] == no3[i % no3.length]) {
                score[2]++;
            }
        }
        
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        ArrayList<Integer> winners = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) {
                winners.add(i + 1); 
            }
        }
        
        answer = new int[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            answer[i] = winners.get(i);
        }

        return answer;
    }
}