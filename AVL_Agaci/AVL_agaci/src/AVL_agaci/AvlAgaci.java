package AVL_agaci;

public class AvlAgaci {
	AvlDugum kok;
	
	AvlDugum ekle(AvlDugum dugum, int icerik) { 
		  
        /* 1.  normal BST aðacý gibi ekleme yap */
        if (dugum == null) 
            return (new AvlDugum(icerik)); 
  
        if (icerik < dugum.icerik) 
            dugum.sol = ekle(dugum.sol, icerik); 
        else if (icerik > dugum.icerik) 
            dugum.sag = ekle(dugum.sag, icerik); 
        else // Duplicate keys not allowed 
            return dugum; 
  
        /* 2. düðüm boyunu güncelle */
        dugum.boy = 1 + max(boy(dugum.sol), boy(dugum.sag)); 
  
        /* 3. denge deðerini al */
        int denge = denge(dugum); 
  
        // 4. rotasyonlar
        //denge fonksiyonu solboy - sagboy iþlemi ile hesaplanýr.
        //eðer dengesizlik varsa(denge=2 ve denge = -2) 4 durum ortaya çýkacaktýr 
        //4.1. Sað rotasyon
        //denge deðeri pozitifse(denge =+2) ve son eklenen düðümün içeriði dengesizliðin belirlendiði düðümün solundaki düðümün içeriðinden küçükse bu rotasyon uygulanýr.
        //þart: denge = 2 ve icerik<dugum.sol.icerik
        //Bu durumda son eklenen eleman dengesizliðin belirlendiði düðümün solunun soluna eklenmiþtir. bu durumda düðümü saða doðru döndürerek dengesizlik düzeltilir.
        if (denge == 2 && icerik < dugum.sol.icerik) 
            return sagRotasyon(dugum); 
  
        //4.2. Sol rotasyon
        //denge deðeri negatifse(denge=-2) ve son eklenen düðümün içeriði dengesizliðin belirlendiði düðümün saðýndaki düðümün içeriðinden büyükse bu rotasyon uygulanýr.  
        //þart: denge=-2 ve icerik>dugum.sag.icerik
        //Bu durumda son eklenen eleman dengesizliðin belirlendiði düðümün saðýnýn saðýna eklenmiþtir. bu durumda düðümü SOLA doðru döndürerek dengesizlik düzeltilir.
        if (denge == -2 && icerik > dugum.sag.icerik) 
            return solRotasyon(dugum); 
  
        //4.3. Sol Sað rotasyon
        //denge deðeri pozitifse(denge=+2) ve son eklenen düðümün içeriði dengesizliðin belirlendiði düðümün solundaki düðümün içeriðinden büyükse bu rotasyon uygulanýr.  
        //þart: denge=+2 ve icerik>dugum.sol.icerik
        //Bu durumda son eklenen eleman dengesizliðin belirlendiði düðümün SOLUnun SAÐIna eklenmiþtir. bu durumda düðümün sol çocuðuna SOL rotasyon, düðüme SAÐ rotasyon uygulanýr. 
        if (denge == 2 && icerik > dugum.sol.icerik) { 
        	System.out.println("SOL SAÐ rotasyon");
            dugum.sol = solRotasyon(dugum.sol); 
            return sagRotasyon(dugum); 
        } 
  
        //4.4. SAÐ SOL rotasyon
        //denge deðeri negatifse(denge=-2) ve son eklenen düðümün içeriði dengesizliðin belirlendiði düðümün saðýndaki düðümün içeriðinden küçükse bu rotasyon uygulanýr.  
        //þart: denge=-2 ve icerik<dugum.sag.icerik
        //Bu durumda son eklenen eleman dengesizliðin belirlendiði düðümün SAÐýnýn SOLuna eklenmiþtir. bu durumda düðümün sað çocuðuna SAÐ rotasyon, düðüme SOL rotasyon uygulanýr. 
        if (denge == -2 && icerik < dugum.sag.icerik) { 
        	System.out.println("SAÐ SOL rotasyon");
            dugum.sag = sagRotasyon(dugum.sag); 
            return solRotasyon(dugum); 
        } 
  
        /* hiçbir rotasyon yapýlmasýdýysa düðümü dön */
        return dugum; 
    }
	
	int denge(AvlDugum dugum) {
		return boy(dugum.sol) - boy(dugum.sag);
	}
	
	int boy(AvlDugum dugum) {
		if(dugum==null)
			return 0;
		else
			return dugum.boy;
	}
	
	int max(int a, int b) {
		if(a>b)
			return a;
		else
			return b;
	}
	void araGezinti(AvlDugum dugum) {
		if(dugum!=null) {
			araGezinti(dugum.sol);
			System.out.print(dugum.icerik +" / ");
			araGezinti(dugum.sag);
		}
	}
	AvlDugum solRotasyon(AvlDugum dugum) {
		AvlDugum y=dugum.sag;
		AvlDugum t2=y.sol;
		System.out.println("SOL rotasyon");
		//rotasyon iþlemi
		y.sol=dugum;
		dugum.sag=t2;
		
		//boy güncellemesi
		dugum.boy=max(boy(dugum.sol), boy(dugum.sag)) + 1;
		y.boy=max(boy(y.sol), boy(y.sag)) +1;
		
		//döndürme sonucu yeni elemaný dön
		return y;
	}
	
	AvlDugum sagRotasyon(AvlDugum dugum) {
		AvlDugum y=dugum.sol;
		AvlDugum t2=y.sag;
		System.out.println("SAG rotasyon");
		//rotasyon iþlemi
		y.sag=dugum;
		dugum.sol=t2;
		
		//boy güncelleme
		dugum.boy=max(boy(dugum.sol), boy(dugum.sag)) + 1;
		y.boy=max(boy(y.sol), boy(y.sag)) +1;
		
		// yeni elemaný dön
		return y;
	}
}
