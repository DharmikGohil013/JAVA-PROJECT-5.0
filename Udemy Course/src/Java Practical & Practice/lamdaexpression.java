public class lamdaexpression {
    public static void main(String[] args) {
        mylamda objqMylamda=()->{
        
         
                System.out.println("dfjb");
        
        };
        objqMylamda.display();
    }
    
}
@FunctionalInterface
interface mylamda{
    public void display();
    

}