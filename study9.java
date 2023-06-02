package Soku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class demo {
    public static double Max(Double[] x) {
        Double max = 0.0;
        for (int i = 0; i <x.length; i++) {
            if (x[i] > max){
                max = x[i];
            }
        }
        return max;
    }

    public static double Min(Double[] x) {
        Double min = 0.0;
        for (int i = 0; i <x.length; i++) {
            if (x[i] < min){
                min = x[i];
            }
        }
        return min;
    }

    public void part1(){
        Scanner sc = new Scanner(System.in);
        Double[] a  = new Double[10];
        System.out.println("请输入十个数");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextDouble();
        }
        System.out.println("您输入的数组为:");
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("最大值为" + Max(a));
        System.out.println("最小值为" + Min(a));
    }

    public void part2(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double[] a = new Double[10];
        System.out.println("请输入十个数");
        for(int i = 0; i < a.length; i++){
            try {
                a[i] = Double.valueOf(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("您输入的数组为:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("最大值为" + Max(a));
        System.out.println("最小值为" + Min(a));
    }

    public static void main (String[]args){
    demo demo1 = new demo();
    demo1.part1();
    demo demo2 = new demo();
    demo2.part2();
    }
}
