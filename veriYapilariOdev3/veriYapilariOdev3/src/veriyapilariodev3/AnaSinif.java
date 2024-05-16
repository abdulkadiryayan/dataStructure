package veriyapilariodev3;

import java.util.LinkedList;

class Eleman {
    String isim;
    String soyisim;
    int telno;

    Eleman(String isim, String soyisim, int telno) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.telno = telno;
    }
}

class Karma {
    LinkedList<Eleman>[] bl;

    @SuppressWarnings("unchecked")
    Karma() {
        // Türkçe alfabesindeki harfler sayısında bağlı liste oluşturuluyor
        bl = new LinkedList[29];
        for (int i = 0; i < 29; i++) {
            bl[i] = new LinkedList<>();
        }
    }

    // Karma fonksiyonu
    private int karmaFonksiyonu(String isim) {
        char firstChar = isim.toUpperCase().charAt(0);
        if (Character.isLetter(firstChar)) {
            return firstChar - 'A';
        } else {
            // Harf değilse, 'Z' altında sırala
            return 28;
        }
    }

    // 1- Karma Tabloya eleman ekleme
    public void elemanEkle(Eleman eleman) {
        int index = karmaFonksiyonu(eleman.isim);
        bl[index].addFirst(eleman);
    }

    // 2- Karma Tablodan eleman silme/çekme
    public Eleman elemanSil(String isim) {
        int index = karmaFonksiyonu(isim);
        LinkedList<Eleman> liste = bl[index];

        for (Eleman eleman : liste) {
            if (eleman.isim.equals(isim)) {
                liste.remove(eleman);
                return eleman;
            }
        }

        return null; // Eleman bulunamazsa null döndür
    }

    // 3- Tüm Karma Tablo listeleme
    public void tabloyuListele() {
        for (int i = 0; i < 29; i++) {
            System.out.print((char) ('A' + i) + " - -> ");
            for (Eleman eleman : bl[i]) {
                System.out.print(eleman.isim + " ");
            }
            System.out.println();
        }
    }

    // 4- Tüm Karma Tablo eleman sayısı
    public int tabloElemanSayisi() {
        int count = 0;
        for (int i = 0; i < 29; i++) {
            count += bl[i].size();
        }
        return count;
    }

    // 5- Herhangi bir harfe ait Karma Tablo listeleme
    public void harfeAitTabloyuListele(char harf) {
        int index = karmaFonksiyonu(String.valueOf(harf));
        System.out.print(harf + " - -> ");
        for (Eleman eleman : bl[index]) {
            System.out.print(eleman.isim + " ");
        }
        System.out.println();
    }

    // 6- Herhangi bir harfe ait Karma Tablo eleman sayısı
    public int harfeAitTabloElemanSayisi(char harf) {
        int index = karmaFonksiyonu(String.valueOf(harf));
        return bl[index].size();
    }
}

public class AnaSinif {
    public static void main(String[] args) {
        Karma karmaTablo = new Karma();

        // Eleman ekleme
        karmaTablo.elemanEkle(new Eleman("Ali", "Yılmaz", 123456));
        karmaTablo.elemanEkle(new Eleman("Ceyda", "Öztürk", 789012));
        karmaTablo.elemanEkle(new Eleman("Zeynep", "Kaya", 345678));

        // Tüm tabloyu listeleme
        karmaTablo.tabloyuListele();

        // Eleman silme/çekme
        Eleman silinenEleman = karmaTablo.elemanSil("Ceyda");
        System.out.println("Silinen Eleman: " + silinenEleman.isim);

        // Tüm tabloyu tekrar listeleme
        karmaTablo.tabloyuListele();

        // Eleman sayısı
        System.out.println("Toplam Eleman Sayısı: " + karmaTablo.tabloElemanSayisi());

        // Belirli bir harfe ait tabloyu listeleme
        karmaTablo.harfeAitTabloyuListele('A');

        // Belirli bir harfe ait tablo eleman sayısı
        System.out.println("A Harfi İçin Eleman Sayısı: " + karmaTablo.harfeAitTabloElemanSayisi('A'));
    }
}
