import java.util.Scanner;

public class LineerSearch {
    public  static int linearSearchIterative(int[] ar,int target)
    {
        for(int i=0 ; i<ar.length ; i++)
        {
            if(ar[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        int[] A = new int[5];
        int n=5;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Element : ");
        for(int i=0;i<n;i++)
        {
            A[i]=sc.nextInt();
        }
        System.out.println("Enter Target Elemnt : ");
         int target;
        target = sc.nextInt();
        System.out.println("You Enter This Target : "+target);
        int Result = linearSearchIterative(A,target);
        System.out.println("In Liner Search Ans : "+Result);
        System.out.println("Now Recursive");
        int Result2=linearSearchRecursive(A,target,0);
        System.out.println("Output is : "+Result2);
    }
    public static int linearSearchRecursive(int[]  arr,int target ,int index)
    {
        if(index >= arr.length)
        {
            return 0;
        }
        if(arr[index]==target)
        {
            return index;
        }
        
return linearSearchRecursive(arr, target, index+1);
        
        
    }
}
