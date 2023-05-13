package Soku;

public class demo {
    public static void main(String[] args) {
        double sum = 0;
        double[][] a = new double[100][100];
        for (int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                double rand = Math.random();
                a[i][j] = rand;
            }
        }
        for (int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++){
                if(i == j){
                    sum += a[i][j];
                }
            }
        }
        System.out.println(sum);

    }
}
