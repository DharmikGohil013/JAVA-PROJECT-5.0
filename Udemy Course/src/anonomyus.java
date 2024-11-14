public class anonomyus {
    public static void main(String[] args) {
        
    }
}

abstract class my{
    abstract void display();
}
class outer{
    public void meth1()
    {
        my obj = new my() {
            System.out.println("sub meth2");
        };
    }
}