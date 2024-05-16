package AVL_agaci;

public class AnaSinif {

	public static void main(String[] args) {
		AvlAgaci aa=new AvlAgaci();
		
		aa.kok=aa.ekle(aa.kok, 100);
		aa.kok=aa.ekle(aa.kok, 50);
		aa.kok=aa.ekle(aa.kok, 75);
		aa.araGezinti(aa.kok);

	}

}
