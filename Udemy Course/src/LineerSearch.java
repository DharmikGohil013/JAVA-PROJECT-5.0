import java.util.Scanner;

public class LineerSearch {
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
    }
}
