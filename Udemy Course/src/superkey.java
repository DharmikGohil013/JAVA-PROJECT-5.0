public class superkey {
    public static void main(String[] args) {
        cubic obj = new cubic(5,10,52);
        obj.dispaly();
    }
}
class cubic extends Rectangle{
    int height;
    int x=20;
    cubic(int l,int b,int h)
    {
        super(l,b);
        this.height=h;
    }
    void dispaly()
    {
        System.out.println(super.x);
        System.out.println(x);
    }
    
}
class Rectangle
{
    int length;
    int breadth;
    int x=10;
    Rectangle()
    {
        length=breadth=1;
    }
    Rectangle(int l,int b)
    {
        length=l;
        breadth=b;
    }
   
}