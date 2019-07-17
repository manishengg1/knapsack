import java.util.Scanner;

//Time complexity = O(counter * sum)
public class Knapsack2 {
	private static int max(int i, int j) {
		return (i > j) ? i : j;
	}

	// Returns the maximum value
	static int knapSack(int sum, int arr[]) {
		int counter = arr.length;
		int K[][] = new int[counter + 1][sum + 1];

		// Build 2-D table k[][]
		for (int i = 0; i <= counter; i++) {
			for (int w = 0; w <= sum; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (arr[i - 1] <= w)
					K[i][w] = max(arr[i - 1] + K[i][w - arr[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[counter][sum];
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