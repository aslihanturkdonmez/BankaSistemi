package turkdonmez.bank;

import java.util.Scanner;

public class HesabaParaYatır extends Hesap {
    
    //Bakiye ve devam tercihi alan scannerlar
    static Scanner bakiyeAlici = new Scanner(System.in);
    static Scanner tercihAlici = new Scanner(System.in);
    
    //Hesap classından kullanıcı menüsüne dönmek ve bilgileri almak için oluşturduğum nesne
    static Hesap kullanıcıBilgileri = new Hesap();
    static Hesap KullanıcıMenüsü = new Hesap();
    
    //Degiskenlerim
    static int Bakiye = kullanıcıBilgileri.bakiye();
    static int YeniBakiye;
    static int tercih;
    static int gönderilecek;

    public static void ParaYatırmaEkranı() {
        System.out.println("Yatıracağınız Miktarı Giriniz : ");
        int girilen = bakiyeAlici.nextInt();
        if (girilen > 0 && girilen <= 1000) {
            YeniBakiye = Bakiye + girilen;
            Bakiye = YeniBakiye;
            System.out.println("İşlem Başarılı");
            YeniBakiyeGöstermeEkranı();
        } else if (girilen == 0) {
            System.out.println("Lütfen Tutar Ekleyiniz");
            ParaYatırmaEkranı();
        } else {
            System.out.println("Tek Seferde 1000 TL ' Ye Kadar Para Yatırılabilir");
            ParaYatırmaEkranı();
        }
    }

    public static void YeniBakiyeGöstermeEkranı() {
        System.out.println("Bakiyeniz :  " + Bakiye + " TL");
        gönderilecek = Bakiye;
        System.out.println("Para Yatırmaya Devam Etmek İçin ' 1 '  Önceki Menüye Dönmek için ' 0 ' Giriniz ");
        tercih = tercihAlici.nextInt();
        if (tercih == 1) {
            ParaYatırmaEkranı();
        } else if (tercih == 0) {
            KullanıcıMenüsü.KullanıcıMenu();
        } else {
            System.out.println("Hatalı Giriş Yapıldı");
            YeniBakiyeGöstermeEkranı();
        }
    }

    public static void YeniBakiyeGöstermeEkranı2() {
        System.out.println("Bakiyeniz :  " + Bakiye + " TL");
        gönderilecek = Bakiye;
        System.out.println("Önceki Menüye Dönmek için ' 0 ' Giriniz ");
        tercih = tercihAlici.nextInt();
        if (tercih == 0) {
            KullanıcıMenüsü.KullanıcıMenu();
        } else {
            System.out.println("Hatalı Giriş Yapıldı");
            YeniBakiyeGöstermeEkranı2();
        }
    }
    
    //Bakiyeyi Döndürme
    public int döndür() {

        return Bakiye;
    }
    //Bakiyeyi Gönderme
    public static int BakiyeDöndürücü() {

        return gönderilecek;
    }

}
