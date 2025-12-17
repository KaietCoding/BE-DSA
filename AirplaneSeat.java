package Java;
	
public class AirplaneSeat {
	public static void main(String[] args) {
		String S= "1A 2F 1C";
		System.out.println(solution(2,S));
	}
	public static int solution(int N, String S) {
        String[] reservedSeats = S.isEmpty() ? new String[0] : S.split(" ");
        
        boolean[][] reserved = new boolean[N + 1][11]; 
        
        for (String seat : reservedSeats) {
            if (seat.isEmpty()) continue;
            int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
            char seatLetter = seat.charAt(seat.length() - 1);
            int seatNum = seatLetter - 'A' + 1; 
            reserved[row][seatNum] = true;
        }
        
        int totalFamilies = 0;
        
        for (int row = 1; row <= N; row++) {
            totalFamilies += countFamiliesInRow(reserved[row]);
        }
        
        return totalFamilies;
    }
    
    private static int countFamiliesInRow(boolean[] reserved) {
        int families = 0;
        int consecutiveSeats = 0;
        
        for (int seat = 1; seat <= 10; seat++) {
            if (!reserved[seat]) {
                consecutiveSeats++;
                
                if (consecutiveSeats == 3) {
                    families++;
                    consecutiveSeats = 0;
                }
            } else {
                consecutiveSeats = 0;
            }
        }
        
        return families;
    }
}
