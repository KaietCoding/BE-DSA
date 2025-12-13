package Java;

public class AdjacencyOfFlippingCoins {
	public static void main(String[] args) {
		int[] A1 = {1, 1, 0, 1, 0, 0};
        System.out.println(getAdjacency(A1));
	}
	
	public static int getAdjacency(int[] a) {
        if (a.length <= 1) {
            return 0;
        }
        
        int initialAdjacency = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
            	initialAdjacency++;
            }
        }
        int maxAdjacency = initialAdjacency;
        
        for (int i = 0; i < a.length; i++) {
            int change = 0;
            
            if (i > 0) {
                if (a[i] == a[i - 1]) {
                    change -= 1;
                } else {
                    change += 1;
                }
            }
            if (i < a.length - 1) {
                if (a[i] == a[i + 1]) {
                    change -= 1;
                } else {
                    change += 1;
                }
            }
            maxAdjacency = Math.max(maxAdjacency, initialAdjacency + change);
        }
        
        return maxAdjacency;
    }
}
