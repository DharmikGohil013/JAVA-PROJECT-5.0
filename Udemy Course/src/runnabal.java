public class runnabal {
    public static void main(String[] args) {
        Mythread t = new Mythread();
        Thread s= new Thread(t);
        s.start();
        int e=0;
        while ( true) {
            System.out.println(e+"world");
            e++;
        }

    }
}
class Mythread implements Runnable
{
    public void run()
    {
        int i=0;
        while (true) {
            System.out.println(i+"hello");
            i++;
        }
    }
}
