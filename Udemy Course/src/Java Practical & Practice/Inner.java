public class Inner {
    public static void main(String[] args) {
        outer.inner obj = new outer().new inner();
        System.out.println(obj.y);
    }
}
class outer{
    class inner{
        int y=10;
       
    }
}
