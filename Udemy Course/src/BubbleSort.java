public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(array);
        bubble(array);
        printArray(array);
    }
    public static void printArray(int[] arr)
    {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void bubble(int[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }   
}