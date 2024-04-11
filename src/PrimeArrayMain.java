import java.util.Random;

public class PrimeArrayMain {
// Initialisierung der Arrays
	private static int[] primeArray = new int[100];
	private static int[] numberArray = new int[100];
	public static void main(String[] args) {
		int primeAmount = 0;
		Random rand = new Random();
// Füllen des numberArrays mit zufälligen zahlen
		for(int i = 0; i < numberArray.length; i++) {
			numberArray[i] = rand.nextInt(1337) + 1;
		}
// Füllen des primeArrays mit Zahlen mithilfe der isPrime Methode
		for (int i = 0; i < numberArray.length; i++) {
			if (isPrime(numberArray[i])) {
				primeArray[primeAmount++] = numberArray[i];
			}
		}
// Min und Max aus dem numberArray mithilfe der findMin und findMax Methode
		int min = findMin(numberArray);
		int max = findMax(numberArray);
// Ausgabe der Primzahlen
		System.out.println("Es gibt " + primeAmount + " Primzahlen in diesem Array.");
        for (int i = 0; i < primeAmount; i++) {
            System.out.println(primeArray[i]);
        }
// Ausgabe der größten und kleinsten Zahl im numberArray und der Anteil an geraden Zahlen
		System.out.println("Der Anteil von geraden Zahlen beträgt: " + amountEven(numberArray) + "%");
		System.out.println("Die kleinste Zahl in dem Array ist: " + min);
		System.out.println("Die größte Zahl in dem Array ist: " + max);
	}
// Methode zur berechnung der Primzahlen
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
// Methode zur berechnung des Anteils gerader Zahlen
	private static double amountEven(int[] numberArray) {
		int evenCount = 0;
		for(int i = 0; i < numberArray.length; i++) {
			if(numberArray[i] % 2 == 0) {
				evenCount++;
			}
		}
		if (numberArray.length == 0) return 0;
		return 100.0 * evenCount / numberArray.length;
	}
// Methode um die kleinste Zahl im numberArray zu finden
	private static int findMin(int[] numberArray) {
		int min = numberArray[0];
		for (int i = 1; i < numberArray.length; i++) {
			if (numberArray[i] < min) {
				min = numberArray[i];
			}
		}
		return min;
	}
// Methode um die größte Zahl im numberArray zu finden
	private static int findMax(int[] numberArray) {
		if (numberArray.length == 0) {
			throw new IllegalArgumentException("Array must not be empty");
		}
		int max = numberArray[0];
		for (int i = 1; i < numberArray.length; i++) {
			if (numberArray[i] > max) {
				max = numberArray[i];
			}
		}
		return max;
	}

}
