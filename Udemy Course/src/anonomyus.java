public class anonomyus {
    public static void main(String[] args) {
        outer obj = new outer();
        obj.meth1();
    }
}

abstract class my{
    abstract public void display();
}
class outer{
    public void meth1()
    {
        my obj = new my() {
            public void display()
            {
                System.out.println("sub meth2");
            }
        };
        obj.display();
    }
}