package Java;

public class Extreme {
	public static void main(String[] args) {
		int[] a= {-9,-4,3,10};
		int[] b= {2,6,9};
		System.out.println(getExtreme(a));
		System.out.println(getExtreme(b));
	}
	
	public static int getExtreme(int[] a) {
		double ave;
		double extreme=0;
		double sum=0.0;
		int index = -1;
		
		if(a.length == 0) return index;
		
		for(int num:a) sum+=num;
		
		ave = sum/a.length;
		
		for(int i=0;i<a.length;i++) {
			if(Math.abs(ave-a[i])>extreme) {
				index = i;
				extreme = Math.abs(ave-a[i]);
			}
		}
		return index;
	}
}
