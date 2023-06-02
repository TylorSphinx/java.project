package Soku;

import java.io.*;
import java.util.ArrayList;

public class Exp1 {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<Integer>();
        inputScores(scores);
        outputScores(scores);
    }

    static void inputScores(ArrayList<Integer> scores) {
        System.out.println("Input q to quit.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        String str1  = "q";
        int i = 0;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(str.equals(str1)){
            System.exit(0);
        }else{
            System.out.println("输入内容");
            try {
                i = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(i < 0 ){
                System.out.println("输入不在范围内");
            }else if (i> 100){
                System.out.println("输入不在范围内");
            }else {
                System.out.println("您输入的为" + i);
            }
        }

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void outputScores(ArrayList<Integer> scores) {
        for (int i = 0; i < scores.size(); i++) {
            System.out.println((i + 1) + ": " + scores.get(i));
        }
    }
}
