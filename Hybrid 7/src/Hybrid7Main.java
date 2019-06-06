
public class Hybrid7Main {

	public static void main (String []argc) {
	
		int lastTwoDig = 0;
		int middleTwoDig = 0;
		int lastDSum = 0;

		
		System.out.println("Number\tlast two digits\t\tmiddle two digits\tlast digits of sum");	
		
		for (int i = 145623; i < 145724; i++) {
			
			lastTwoDig= i % 100;
			middleTwoDig= (i/100) %100;
			lastDSum += i%10;
			int store = i;
		for ( int a = 1; a< 6; a++ ) {
			
			store /=10;

			int sum3 = store %10;
			lastDSum += sum3;
			
			}
			
			
			

			System.out.println(i+"\t\t"+lastTwoDig+ "\t\t\t"+middleTwoDig+"\t\t\t"+lastDSum);
			lastDSum = 0;
		}
		

	
	}
}
