import java.util.Scanner;
//Best Solution
//Time complexity = O(counter * sum)
public class Knapsack {
	private static int max(int i, int j) {
		return (i > j) ? i : j;
	}

	// Returns the maximum value
	private static int knapSack(int sum, int[] arr) {

		// Create a Table with max. value for each position.
		int table[] = new int[sum + 1];

		// Fill the table with below specified formula
		for (int i = 0; i <= sum; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] <= i) {
					table[i] = max(table[i], table[i - arr[j]] + arr[j]);
				}
			}
		}
		return table[sum];
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int t = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Input an integer");
		t = input.nextInt();
		if (t < 10 && t > 0) {
			int mainArr[][] = new int[t][];
			int sumArr[] = new int[t];
			boolean invalidData = false;
			for (int i = 0; i < t; i++) {
				System.out.println("Input arraySize and Sum:");
				int arraySize = input.nextInt();
				int arr[] = new int[arraySize];
				int sum = input.nextInt();
				if (arraySize <= 0 || sum <= 0) {
					invalidData = true;
					break;
				}
				for (int j = 0; j < arraySize; j++) {
					System.out.println("Input Array Elements:");
					arr[j] = input.nextInt();
				}
				mainArr[i] = arr;
				sumArr[i] = sum;

			}
			if (invalidData) {
				System.out.println("Invalid Data");
				return;
			}
			for (int i = 0; i < mainArr.length; i++) {
				System.out.println("output is: " + knapSack(sumArr[i], mainArr[i]));
			}
		}
		System.out.println("Out of loop");
	}

}