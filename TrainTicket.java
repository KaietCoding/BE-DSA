package Java;

import java.util.HashSet;
import java.util.Set;

public class TrainTicket {
	public static void main(String[] args) {
		int[] a= {1,4,8,9,10,27,28,29,30};
		System.out.println(solution(a));
	}
	
	public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int maxDay = 30;
        Set<Integer> travelDays = new HashSet<>();
        for (int day : A) {
            travelDays.add(day);
        }

        
        int[] dp = new int[maxDay + 1];

        for (int i = 1; i <= maxDay; i++) {
            
            if (!travelDays.contains(i)) {
                dp[i] = dp[i-1];
                continue;
            }

            int cost1Day = dp[i-1] + 2;

            int day7Ago = Math.max(0, i - 7);
            int cost7Day = dp[day7Ago] + 7;

            int cost30Day = 25;
            
            dp[i] = Math.min(cost1Day, Math.min(cost7Day, cost30Day));
        }

        return dp[maxDay];
    }
}
