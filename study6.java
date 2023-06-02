package Soku;

public class Complex {
    double real, img;
    public Complex()
    {
        this.real=0.0;
        this.img=0.0;
    }
    public Complex(double real,double img)
    {
        this.real=real;
        this.img=img;
    }
    public double getReal()
    {
        return this.real;
    }
    public double getimg()
    {
        return this.img;
    }
    public void setReal(double real)
    {
        this.real=real;
    }
    public void setImg(double img)
    {
        this.img=img;
    }
    public Complex add(Complex a,Complex b)
    {
        Complex temp = new Complex();
        temp.real = a.real+b.real;
        temp.img = a.img+b.img;
        return temp;
    }
    public Complex dec(Complex a,Complex b)
    {
        Complex temp = new Complex();
        temp.real = a.real-b.real;
        temp.img = a.img-b.img;
        return temp;
    }
    public Complex mul(Complex a,Complex b)
    {
        Complex temp = new Complex();
        temp.real = a.real*b.real-a.img*b.img;
        temp.img = a.real*b.img+a.img*b.real;
        return temp;
    }
    public Complex div(Complex a,Complex b)
    {
        Complex temp = new Complex();
        temp.real=(a.real*b.real+a.img*b.img)/(b.real*b.real+b.img*b.img);
        temp.img =(a.img*b.real-a.real*b.img)/(b.real*b.real+b.img*b.img);
        return temp;
    }
    public void Modulo()
    {
        System.out.println("模长为:"+Math.pow((Math.pow(this.real,2)+Math.pow(this.img,2)),0.5));
    }
    public void Print()
    {
        System.out.println(this.real+"+"+this.img+"i");
    }
    @Override
    public String toString(){
        return this.real+"+"+this.img+"j";
    }
    @Override
    public boolean equals(Object tmp){
        if(tmp == null) {
            return false;
        } else{
            if(tmp instanceof Complex){
                Complex c =(Complex) tmp;
                return this.real == c.real && this.img == c.img;
            }
            else {
                return false;
            }
        }
    }
    public static void main(String[] args){
        Complex a = new Complex(2.0,1.0);
        Complex b = new Complex(4.0,2.0);
        Complex temp = new Complex(3,4);
        Complex add = new Complex();
        Complex dec = new Complex();
        Complex mul = new Complex();
        Complex div = new Complex();
        add = add.add(a,b);
        add.Print();
        dec = dec.dec(a,b);
        dec.Print();
        mul = mul.mul(a,b);
        mul.Print();
        div = div.div(a,b);
        div.Print();
        temp.Modulo();
        System.out.println(temp.toString());
        System.out.println("相等情况:"+a.equals(b));
    }
}
