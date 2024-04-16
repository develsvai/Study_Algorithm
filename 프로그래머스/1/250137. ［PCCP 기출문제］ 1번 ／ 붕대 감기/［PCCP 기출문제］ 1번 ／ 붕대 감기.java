import java.util.*;
public class Solution {


    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxHealth = health;
        int maxTime = 0;
        int current_seccess = 0;
        
        for (int[] arr : attacks) {
            maxTime = arr[0];
        }


        for (int i = 1; i <= maxTime; i++) {
            int flag = 0;
            
            for (int[] attack : attacks) {
                int attTime = attack[0];
                int attackDamage = attack[1];
                if (attTime == i) {
                    flag = 1;
                    health -= attackDamage;
                    current_seccess = 0;
                }
            }
            
            if( flag == 0 ) {
                health += bandage[1];
                current_seccess++;

                if (current_seccess == bandage[0]) {
                    health += bandage[2];
                    current_seccess =0;
                }
                
                if( health > maxHealth){
                    health = maxHealth;
                }
            }
            
            if (health <= 0) {
                return -1;
            }
        }

        return health;
    }
}


/**

**/