package Soku;

public class demo {
    public static void main(String[] args) {
        int num = 0;
        for (int i = 1900; i <2022;i++){
            if (((i % 4 == 0) && (i % 100 != 0))|(i % 400 == 0) ){
                System.out.print(i + "  ");
                num++;
                if(num == 5){
                    System.out.println();
                    num = 0;
                }
            }
        }
    }
}
