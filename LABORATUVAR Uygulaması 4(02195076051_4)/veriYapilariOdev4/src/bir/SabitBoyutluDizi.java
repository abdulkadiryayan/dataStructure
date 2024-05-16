package bir;

public class SabitBoyutluDizi {
    private int[] dizi;
    private int boyut;

    public SabitBoyutluDizi(int boyut) {
        this.boyut = boyut;
        this.dizi = new int[boyut];
    }

    public void DiziYaz() {
        for (int i = 0; i < boyut; i++) {
            System.out.print(dizi[i] + " ");
        }
        System.out.println();
    }

    // Başa Ekleme
    public void bastaEkle(int eleman) {
        for (int i = boyut - 1; i > 0; i--) {
            dizi[i] = dizi[i - 1];
        }
        dizi[0] = eleman;
        DiziYaz();
    }

    // Orta Ekleme
    public void ortayaEkle(int indeks, int eleman) {
        for (int i = boyut - 1; i > indeks; i--) {
            dizi[i] = dizi[i - 1];
        }
        dizi[indeks] = eleman;
        DiziYaz();
    }

    // Sona Ekleme
    public void sonaEkle(int eleman) {
        dizi[boyut - 1] = eleman;
        DiziYaz();
    }

    // Baştan Silme
    public void bastanSil() {
        for (int i = 0; i < boyut - 1; i++) {
            dizi[i] = dizi[i + 1];
        }
        dizi[boyut - 1] = 0;
        DiziYaz();
    }

    // Orta Silme
    public void ortadanSil(int indeks) {
        for (int i = indeks; i < boyut - 1; i++) {
            dizi[i] = dizi[i + 1];
        }
        dizi[boyut - 1] = 0;
        DiziYaz();
    }

    // Sondan Silme
    public void sondanSil() {
        dizi[boyut - 1] = 0;
        DiziYaz();
    }

    public static void main(String[] args) {
        SabitBoyutluDizi dizi = new SabitBoyutluDizi(5);

        dizi.bastaEkle(2);
        dizi.ortayaEkle(2, 4);
        dizi.sonaEkle(6);

        dizi.bastanSil();
        dizi.ortadanSil(1);
        dizi.sondanSil();
    }
}
