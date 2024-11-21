import java.util.Scanner;

public class java1 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toUpperCase();
        input.toLowerCase();
        System.out.println("output is: "+input.toLowerCase());    
    }
}
