package day2;

public class Fibo {
    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 0;
        int n3 = 1;
        while (n1 < 100) {
            n2 = n3;
            n3 = n1;
            n1 = n2 + n3;
            System.out.println(n3);
        }
    }
}
