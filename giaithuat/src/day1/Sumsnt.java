package day1;

public class Sumsnt {
    public static void main(String[] args) {
        int number = 100;
        int count = 0;
        for (int i = 0; i < number; i++) {
            if (number % i == 0){
                count++;
            }
        }
    }
}
