package bes_2;

public class Dugum {
    int veri;
    Dugum sol, sag;

    public Dugum(int veri) {
        this.veri = veri;
        sol = sag = null;
    }

    public void ekle(int yeniVeri) {
        if (yeniVeri < veri) {
            if (sol == null) {
                sol = new Dugum(yeniVeri);
            } else {
                sol.ekle(yeniVeri);
            }
        } else if (yeniVeri > veri) {
            if (sag == null) {
                sag = new Dugum(yeniVeri);
            } else {
                sag.ekle(yeniVeri);
            }
        }
        // Aynı değer varsa hiçbir şey yapma (BST'de eşit değerlere izin verilmez)
    }

    public Dugum sil(int silinecekVeri) {
        if (silinecekVeri < veri && sol != null) {
            sol = sol.sil(silinecekVeri);
        } else if (silinecekVeri > veri && sag != null) {
            sag = sag.sil(silinecekVeri);
        } else {
            // Silinecek düğümü bulduk
            if (sol == null) {
                return sag;
            } else if (sag == null) {
                return sol;
            }

            // İki çocuğu olan düğümü silme
            veri = sag.enKucukDugumuAl();
            sag = sag.sil(veri);
        }

        return this; // Güncellenmiş düğümü döndür
    }

    private int enKucukDugumuAl() {
        return (sol == null) ? veri : sol.enKucukDugumuAl();
    }

    public void araGezinti() {
        if (sol != null) {
            sol.araGezinti();
        }
        System.out.print(veri + " ");
        if (sag != null) {
            sag.araGezinti();
        }
    }

    public static void main(String[] args) {
        Dugum kok = new Dugum(50);

        // Test için düğümler ekle
        kok.ekle(30);
        kok.ekle(70);
        kok.ekle(20);
        kok.ekle(40);
        kok.ekle(60);
        kok.ekle(80);

        // Ara gezintiyi yazdır
        System.out.print("Ara Gezinti: ");
        kok.araGezinti();
        System.out.println();

        // Düğüm sil
        kok = kok.sil(30);

        // Silindikten sonraki ara gezintiyi yazdır
        System.out.print("Ara Gezinti (30 silindi): ");
        kok.araGezinti();
        System.out.println();
    }
}
