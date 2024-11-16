public class DynemicMethodDispach {
    public static void main(String[] args) {
        super1 obj = new sub();
        obj.method1();
        obj.method2();
        
    }
}
class sub extends super1{
    @Override
    public void method2()
    {
        System.out.println("sub meth2");
    }
    public void method3()
    {
        System.out.println("sub meth3");
    }
}
class super1{
    public void method1()
    {
        System.out.println("super meth1");
    }
    public void method2(){
        System.out.println("meth2");
    }
}