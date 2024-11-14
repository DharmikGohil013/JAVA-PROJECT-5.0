import java.util.Scanner;

public class exeptions {
    public static void main(String[] args) {
        int a,b,c;
        
        Scanner se= new Scanner(System.in);
        a=se.nextInt();
        b=se.nextInt();
        try{
            c=a/b;
        }
        catch(ArithmeticException e){
            System.out.println("Can't Divied");

        }
        System.out.println("Over10");
    }
}
