import java.util.Scanner;

/* A recursive implementation*/
//Time complexity = O(2^n)
class KnapsackRecursive {

	// Returns maximum among two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Returns the maximum value
	static int knapSack(int sum, int arr[], int counter) {
		if (counter == 0 || sum == 0)
			return 0;

		// If arr element is more than the Knapsack capacity, then
		// ignore this element
		if (arr[counter - 1] > sum)
			return knapSack(sum, arr, counter - 1);

		// Return the maximum value
		else
			return max(arr[counter - 1] + knapSack(sum - arr[counter - 1], arr, counter),
					knapSack(sum, arr, counter - 1));
	}

	// Driver program to test above function
	public static void main(String args[]) {

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
				System.out.println("output is: " + knapSack(sumArr[i], mainArr[i], mainArr[i].length));
			}
		}
		System.out.println("Out of loop");
	}
}