import java.util.Random;

public class PrimeArrayMain {
	public static void main(String[] args) {
		int primeAmount = 0;
		int[] primeArray = new int[50];
		int[] numberArray = new int[50];
		Random rand = new Random();
		
		for(int i = 0;i < numberArray.length; i++) {
			numberArray[i] = rand.nextInt(1337);
		}
		for (int i = 0; i < numberArray.length; i++) {
			if (isPrime(numberArray[i])) {
				System.out.println(numberArray[i]);
				primeAmount++;
				primeArray[i] = numberArray[i];
			}
		}
		System.out.println("Es gibt " + primeAmount + " Primezahlen in diesem Array.");
	}
	private static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
