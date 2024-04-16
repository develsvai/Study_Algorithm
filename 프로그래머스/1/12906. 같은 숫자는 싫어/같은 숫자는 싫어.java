import java.util.*;

public class Solution {
   public int[] solution(int []arr) {
        int[] answer = {};
        int tmp = -1;

        ArrayList<Integer> numArr= new ArrayList<>();

        for(int i =0; i< arr.length; i++) {
            if( tmp != arr[i]) {
                tmp = arr[i];
                numArr.add(arr[i]);
            }

        }

        answer = new int[numArr.size()];
        for(int i=0; i< numArr.size(); i++){
            answer[i] = numArr.get(i);
        }

        return answer;
    }
}