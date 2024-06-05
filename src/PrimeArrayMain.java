import java.util.Random;

public class PrimeArrayMain {
// Initialisierung der Arrays
	private static int[] primeArray = new int[1000];
	private static int[] numberArray = new int[1000];
	public static void main(String[] args) {
		int primeAmount = 0;
		Random rand = new Random();
// Füllen des numberArrays mit zufälligen zahlen
		for(int i = 0; i < numberArray.length; i++) {
			numberArray[i] = rand.nextInt(1000) + 1;
		}
// Füllen des primeArrays mithilfe der isPrime Methode und der isInArray Methode
		for (int i = 0; i < numberArray.length; i++) {
			if (isPrime(numberArray[i]) && !isInArray(primeArray, primeAmount, numberArray[i])) {
				primeArray[primeAmount++] = numberArray[i];
			}
		}
// Min und Max aus dem numberArray mithilfe der findMin und findMax Methode
		int min = findMin(numberArray);
		int max = findMax(numberArray);
// Ausgabe der Primzahlen
		System.out.println("Es gibt " + primeAmount + " Primzahlen in diesem Array.");
		displayPrimes(primeArray, primeAmount);
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

// Methode zur Überprüfung, ob eine Zahl bereits im Array ist
private static boolean isInArray(int[] array, int length, int num) {
	for (int i = 0; i < length; i++) {
		if (array[i] == num) {
			return true;
		}
	}
	return false;
}

// Methode zur verbesserten Darstellung der Primzahlen
private static void displayPrimes(int[] primes, int count) {
	int primesPerLine = 10; // Anzahl der Primzahlen pro Zeile
	for (int i = 0; i < count; i++) {
		System.out.printf("%5d", primes[i]);
		if ((i + 1) % primesPerLine == 0) {
			System.out.println();
		}
	}
	if (count % primesPerLine != 0) {
		System.out.println(); // Zeilenumbruch, wenn die letzte Zeile nicht voll ist
	}
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
