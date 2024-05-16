package uc;

public class GCDCalculator {

    // Özyinelemeli GCD hesaplama fonksiyonu
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x; 
        } else {
            return gcd(y, x % y); 
        }
    }

    public static void main(String[] args) {
        int sayi1 = 48;
        int sayi2 = 18;

        int sonuc = gcd(sayi1, sayi2);
        System.out.println("OBEB(" + sayi1 + ", " + sayi2 + ") = " + sonuc);
    }
}
