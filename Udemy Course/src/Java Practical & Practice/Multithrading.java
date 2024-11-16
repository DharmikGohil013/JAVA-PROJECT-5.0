public class Multithrading {
    public static void main(String[] args) {
        Mythread t = new Mythread();
        t.start();
        int e=0;
        while ( true) {
            System.out.println(e+"world");
            e++;
        }

    }
}
class Mythread extends Thread
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
