import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int answer = 0;
        int max = 0;
        int weight_value = 0;
        int height_value = 0;
        
        //배열의 가장 큰값 
        for( int[] arr : sizes){
            for( int row : arr){
                if( row > max ){
                    max = row;
                }
            }
        }
        
        weight_value = max;
        
        for (int[] arr : sizes) {
            if (arr[0] < arr[1]) {
                // 두 값의 위치를 변경하여 뒤집기
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
        }
        
        // sizes 배열 순회
        int[] heightArray = new int[sizes.length];
        int cou =0;
        // sizes 배열 순회
        for (int[] arr : sizes) {
            heightArray[cou] = arr[1];
            cou ++ ;
        }
        
        int maxHeight = Integer.MIN_VALUE;
        

        // heightArray 배열에서 가장 큰 값 찾기
        for (int height : heightArray) {
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        
        height_value = maxHeight;
        
        answer = height_value * weight_value;
        
        return answer;

    }
    
}


/**
가장 긴 가로 89
가장 긴 세로 70

1. 배열에서 가장큰값은 무조건 가로 길이 
2. 배열의 각 원소 값들을 배교해서 가로가 세로보다 짧을 경우 값을 뒤집음
3. 세로 값들 중에서 가장큰값 


**/