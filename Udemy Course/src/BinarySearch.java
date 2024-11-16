import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        // Input: Sorted Array elements
        System.out.println("Enter the elements of the array in sorted order:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter the target element to search: ");
        int target = scanner.nextInt();
        int iterativeResult = binarySearchIterative(array, target);
        System.out.println("Result : - "+iterativeResult);
        int recursiveResult = binarySearchRecursive(array, target, 0, size - 1);
        System.out.println("Result : - "+recursiveResult);
    }
    public static int binarySearchIterative(int[]  arr,int target)
    {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) 
            {
                return mid; // Target found
            }
            else if (arr[mid] < target) 
            {
                left = mid + 1; // Search in the right half
            }
            else if(arr[mid] >target) 
            {
                right = mid - 1; // Search in the left half
            }
        }

        return 0;
    }
    public static int binarySearchRecursive(int[]  arr,int target,int left,int right)
    {
        if (left > right) {
            return -1; // Target not found
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) 
        {
            return mid; // Target found
        } 
        else if (arr[mid] < target) 
        {
            return binarySearchRecursive(arr, target, mid + 1, right); // Search in the right half
        }
        else
        {
            return binarySearchRecursive(arr, target, left, mid-1);
        }
        
    }
}
