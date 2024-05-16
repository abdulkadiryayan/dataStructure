package bes_1;

public class Pascal {

    public int recPascal(int satir, int sutun) {
        // Üçgenin kenarlarında bulunan değerler her zaman 1'dir.
        if (sutun == 0 || sutun == satir) {
            return 1;
        } else {
            // Diğer değerleri hesaplamak için özyinelemeli olarak kendisini çağırır.
            return recPascal(satir - 1, sutun - 1) + recPascal(satir - 1, sutun);
        }
    }

    public static void main(String[] args) {
        Pascal psc = new Pascal();
        for (int sat = 0; sat < 10; sat++) {
            System.out.println();
            for (int sut = 0; sut < sat + 1; sut++)
                System.out.print(psc.recPascal(sat, sut) + " ");
        }
    }
}
