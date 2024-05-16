package dort;

public class StringReverser {

    // Özyinelemeli Reverse fonksiyonu
    public static void reverse(char[] s, int start, int end) {
        if (start < end) {
            // Swap işlemi
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            // Recursion fonksiyonunu devam ettir
            reverse(s, start + 1, end - 1);
        }
    }

    public static void main(String[] args) {
        // Test için örnek bir karakter dizisi
        char[] charArray = "Merhaba".toCharArray();

        // Reverse fonksiyonunu çağır ve ekrana yazdır
        reverse(charArray, 0, charArray.length - 1);

        System.out.println(charArray);
    }
}
