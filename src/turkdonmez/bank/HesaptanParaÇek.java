package turkdonmez.bank;

import java.util.Scanner;

public class HesaptanParaÇek extends Hesap {
    
    //Bakiye ve devam tercihi alan scannerlar
    static Scanner bakiyeAlici = new Scanner(System.in);
    static Scanner tercihAlici = new Scanner(System.in);

    //Hesap classından kullanıcı menüsüne dönmek için oluşturduğum nesne
    static Hesap KullanıcıMenüsü = new Hesap();
    //Borç Durumunda Hesaba para yatırmak için para yatırma classından tanımladığım nesneler
    static HesabaParaYatır kullanıcıBilgileri = new HesabaParaYatır();
    static HesabaParaYatır paraYatir = new HesabaParaYatır();
    
    //Bakiye ve devam tercihi değişkenleri
    static int Bakiye = kullanıcıBilgileri.BakiyeDöndürücü();
    static int YeniBakiye;
    static int tercih;
    
    
    public static void ParaCekmeEkranı() {
        System.out.println("Cekeceğiniz Miktarı Giriniz : ");
        int girilen = bakiyeAlici.nextInt();
        if (girilen > 0 && girilen < 1000) {
            if (kullanıcıBilgileri.Bakiye > 0) {
                YeniBakiye = kullanıcıBilgileri.Bakiye - girilen;
                kullanıcıBilgileri.Bakiye = YeniBakiye;
                System.out.println("İşlem Başarılı");
                YeniBakiyeGöstermeEkranı();
            } else if (kullanıcıBilgileri.Bakiye <= 0) {
                System.out.println("Hesabınız Ekside Lütfen Borcunuzu Ödeyiniz");
                paraYatir.ParaYatırmaEkranı();
            }
        } else {
            System.out.println("Tek Seferde 0 TL ile 1000 TL Arası Para Cekilebilir");
            ParaCekmeEkranı();
        }
    }

    public static void YeniBakiyeGöstermeEkranı() {
        System.out.println("Yeni Bakiyeniz :  " + kullanıcıBilgileri.Bakiye + " TL");
        System.out.println("Para Cekmeye Devam Etmek İçin ' 1 '  Önceki Menüye Dönmek için ' 0 ' Giriniz ");
        tercih = tercihAlici.nextInt();
        if (tercih == 1) {
            ParaCekmeEkranı();
        } else if (tercih == 0) {
            KullanıcıMenüsü.KullanıcıMenu();
        } else {
            System.out.println("Hatalı Giriş Yapıldı");
            YeniBakiyeGöstermeEkranı();
        }
    }
    
    //Bakiyeyi döndürme kodu
    public int döndür() {

        return kullanıcıBilgileri.Bakiye;
    }

}
