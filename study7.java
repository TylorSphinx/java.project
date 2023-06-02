package Soku;

public class Point {
    double x,y;
    public Point(){
        this.x=0;
        this.y=0;
    }
    public Point(double x,double y){
        this.x=x;
        this.y=y;
    }
    interface Shape{
        public double computeArea();
        public double computeDiameter();
    }
    static class Triangle implements Shape
    {
        static double AB;
        static double AC;
        static double BC;
        public Triangle(Point A, Point B, Point C){
            double AB_sqrt = Math.pow((B.y-A.y),2)+Math.pow((B.x-A.x),2);
            double AC_sqrt = Math.pow((C.y-A.y),2)+Math.pow((C.x-A.x),2);
            double BC_sqrt = Math.pow((B.y-C.y),2)+Math.pow((B.x-C.x),2);
            AB = Math.pow(AB_sqrt,0.5);
            AC = Math.pow(AC_sqrt,0.5);
            BC = Math.pow(BC_sqrt,0.5);
            if(Math.pow(AB_sqrt,0.5)+Math.pow(AC_sqrt,0.5)>Math.pow(BC_sqrt,0.5)&&Math.pow(AB_sqrt,0.5)+Math.pow(AC_sqrt,0.5)>Math.pow(AC_sqrt,0.5)&&Math.pow(BC_sqrt,0.5)+Math.pow(AC_sqrt,0.5)>Math.pow(AB_sqrt,0.5))
            {
                System.out.println("这三点能构成三角形");
            }
            else
            {
                System.out.println("这三点不能构成三角形");
            }
        }
        @Override
        public double computeArea() {
            double p;
            p=(AB+BC+AC)/2;
            return Math.pow((p*(p-AB)*(p-AC)*(p-BC)),0.5);
        }

        @Override
        public double computeDiameter() {
            return AB+AC+BC;
        }
        Point temp = new Point();
        public double getter_x()
        {
            return this.temp.x;
        }
        public double getter_y()
        {
            return this.temp.y;
        }
        public double setter_x()
        {
            return this.temp.x;
        }
        public double setter_y()
        {
            return this.temp.y;
        }
    }
    static class Rectangle implements Shape
    {
        static double AB;
        static double AC;
        static double BD;
        static double DC;
        static double AD;
        static double BC;
        Point temp = new Point();
        public Rectangle(Point A, Point B, Point C,Point D){
            double AB_sqrt = Math.pow((B.y-A.y),2)+Math.pow((B.x-A.x),2);
            double AC_sqrt = Math.pow((C.y-A.y),2)+Math.pow((C.x-A.x),2);
            double BD_sqrt = Math.pow((B.y-D.y),2)+Math.pow((B.x-D.x),2);
            double DC_sqrt = Math.pow((D.y-C.y),2)+Math.pow((D.x-C.x),2);
            double AD_sqrt = Math.pow((D.y-A.y),2)+Math.pow((D.x-A.x),2);
            double BC_sqrt = Math.pow((B.y-C.y),2)+Math.pow((B.x-C.x),2);
            AB = Math.pow(AB_sqrt,0.5);
            AC = Math.pow(AC_sqrt,0.5);
            BD = Math.pow(BD_sqrt,0.5);
            DC = Math.pow(DC_sqrt,0.5);
            AD = Math.pow(AD_sqrt,0.5);
            BC = Math.pow(BC_sqrt,0.5);
            if(AB!=DC||AD!=BC||AB_sqrt+AC_sqrt!=BC_sqrt)
            {
                System.out.println("这四点不能构成矩形");
            }
        }
        public double getter_x()
        {
            return this.temp.x;
        }
        public double getter_y()
        {
            return this.temp.y;
        }
        public double setter_x()
        {
            return this.temp.x;
        }
        public double setter_y()
        {
            return this.temp.y;
        }
        @Override
        public double computeDiameter() {
            return AB*AC;
        }

        @Override
        public double computeArea() {
            return 2*(AB+AC);
        }
        public void draw()
        {
            System.out.println("这是一个矩形");
        }
    }
    static class Circle implements Shape
    {
        static double r;
        Point temp;
        public Circle(Point A,double radius)
        {
            temp=A;
            r=radius;
        }
        public double getter_x()
        {
            return this.temp.x;
        }
        public double getter_y()
        {
            return this.temp.y;
        }
        public double setter_x()
        {
            return this.temp.x;
        }
        public double setter_y()
        {
            return this.temp.y;
        }
        @Override
        public double computeArea() {
            return 0.5*Math.PI*Math.pow(r,2);
        }

        @Override
        public double computeDiameter() {
            return 2*Math.PI*r;
        }
    }
    static class Square extends Rectangle
    {
        public Square(Point A, Point B, Point C, Point D)
        {
            super(A, B, C, D);
            if(AB==AC&&AB==BD&&AB==DC)
            {
                System.out.println("这是正方形");
            }
            else
            {
                System.out.println("这不是正方形");
            }
        }
        @Override
        public void draw(){
            System.out.println("这是一个正方形");
        }
    }
    public static void main(String[] args)
    {
        Point A = new Point(0,0);
        Point B = new Point(3,0);
        Point C = new Point(0,3);
        Point D = new Point(3,3);
        Triangle sjx = new Triangle(A, B, C);
        Rectangle jx = new Rectangle(A, B, C, D);
        Circle cirle = new Circle(A, 2);
        Square zfx = new Square(A, B, C, D);
        Rectangle many_test = new Square(A, B, C, D);
        System.out.println("三角形面积:"+sjx.computeDiameter());
        System.out.println("矩形面积:"+jx.computeDiameter());
        System.out.println("正方形面积:"+zfx.computeDiameter());
        System.out.println("圆形面积:"+cirle.computeDiameter());
        System.out.println("三角形周长:"+sjx.computeArea());
        System.out.println("矩形周长:"+jx.computeArea());
        System.out.println("正方形周长:"+zfx.computeArea());
        System.out.println("圆形周长:"+cirle.computeArea());
    }
}
