package Soku;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo1 extends Thread{

    public void run1() {
        System.out.println(getName()+" is running...");
        try {
            FileWriter fw = new FileWriter("thread1.txt");
            BufferedWriter buf1 = new BufferedWriter(fw);
            int a,b,c;
            for (int i = 100 ; i < 1000; i++){
                a = i / 100;
                b = (i / 10) % 10;
                c = (i / 1) % 10;
                if(i == a*a*a + b*b*b + c*c*c){
                    buf1.write(i  + "   ");
                    buf1.newLine();
                }
            }
            buf1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run2() {
        System.out.println(getName()+" is running...");
        try {
            FileWriter fw = new FileWriter("leapYear.txt");
            BufferedWriter buf2 = new BufferedWriter(fw);
            int num = 0;
            for (int i = 1900; i <2022;i++){
                if (((i % 4 == 0) && (i % 100 != 0))|(i % 400 == 0) ){
                    buf2.write(i  + "   ");
                    buf2.newLine();
                    num++;
                    if(num == 5){
                        System.out.println();
                        num = 0;
                    }
                }
            }
            buf2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Demo1 demo2 = new Demo1();
        demo1.run1();
        demo2.run2();
    }
}
