import java.util.*;




import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> reqarray = new ArrayList<>();

        for (int[] arr : data) {
            if (ext.equals("code")) {
                if (arr[0] < val_ext) {
                    reqarray.add(arr);
                }
            } else if (ext.equals("date")) {
                if (arr[1] < val_ext) {
                    reqarray.add(arr);
                }
            } else if (ext.equals("maximum")) {
                if (arr[2] < val_ext) {
                    reqarray.add(arr);
                }
            } else {
                if (arr[3] < val_ext) {
                    reqarray.add(arr);
                }
            }
        }

        if (sort_by.equals("code")) {
            Collections.sort(reqarray, Comparator.comparingInt(a -> a[0]));
        } else if (sort_by.equals("date")) {
            Collections.sort(reqarray, Comparator.comparingInt(a -> a[1]));
        } else if (sort_by.equals("maximum")) {
            Collections.sort(reqarray, Comparator.comparingInt(a -> a[2]));
        } else {
            Collections.sort(reqarray, Comparator.comparingInt(a -> a[3]));
        }

        int[][] answer = new int[reqarray.size()][];
        for (int i = 0; i < reqarray.size(); i++) {
            answer[i] = reqarray.get(i);
        }

        return answer;
    }
}


/**
1. 데이터들이 담긴 2차원 정수 리스트 data
2. 어떤 기준으로 데이터 를 뽑아낼지 의미하는 ext 
3. 뽑아낼 정보의 기준값 val_ext
4. 정보를 정렬할 기준이 되는 문자열 ort_by 

data 에서 ext < val_ext 보다 작은값 추출

sort_by 값을 기준으로 정렬 하여 리턴 
**/