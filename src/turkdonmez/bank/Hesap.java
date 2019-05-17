package turkdonmez.bank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;

public class Hesap {
    
    //Hesap Bilgisi Değişkenleri
    public static String isim[] = new String[100];
    public static String Soyisim[] = new String[100];
    public static int DogumYılı[] = new int[100];
    public static String KayıtTarihi[] = new String[100];
    public static String HesapNumarası[] = new String[100];
    public static int Yas[] = new int[100];
    public static String Sifre[] = new String[100];
    public static int Bakiye[] = new int[100];
    
    //Bakiyeyi Para Yatırma veya Çekme Ekranına Gönderen method
    public int bakiye() {
        return Bakiye[KullanıcıSayacı];
    }
    
    //Para yatırma ekranı için oluşturduğum nesnem
    static HesabaParaYatır bakiyeGöster = new HesabaParaYatır();
   
    //Tercih alıcı Scannerlarım
    static Scanner tercih1 = new Scanner(System.in);
    static Scanner tercih2 = new Scanner(System.in);
   
    //Tercih kaydedici değişkenlerim
    static int secim1;
    static int secim2;
    
    //Müşteri sayısı değişkenim
    static int KullanıcıSayacı = 0;
    
    //Bilgileri alan Scannerlarım
    static Scanner BilgiAlici = new Scanner(System.in);
    static Scanner SifreAlici = new Scanner(System.in);
    
    //Anamenü Methodum
    public static void AnaMenü() {
        System.out.println("\n+++++++++TurkDonmez Bank'a Hoşgeldiniz++++++++++");
        System.out.println(" ---Lütfen Yapmak İstediğiniz İşlemi Seçiniz---");
        System.out.println("      1----> Banka Sistemine Üye Ol <------1");
        System.out.println("     2---->  Tüm Müşterileri Listele  <------2");
        System.out.println("    3----> Tüm Müşterileri .txt Olarak Kaydet <------3");
        System.out.println("     4----> Neden TurkDonmez Bankası ?<------4");
        System.out.println("        5----> Uygulamadan Ayrıl <------5");
        Scanner SecimAlici = new Scanner(System.in);
        System.out.println("\nSeçiminiz : ");
        secim1 = tercih1.nextInt();

        while (secim1 != 5) {
            switch (secim1) {
                case 1:
                    Kaydol();
                    SayacıArtırma();
                    KullanıcıMenu();
                    break;
                case 2:
                    Listele();
                    System.out.println("\n İşlem Başarılı Ana Menüye Yönlendirildiniz.");
                    AnaMenü();
                    break;

                case 3:
                    textKaydet();
                    System.out.println("\nDosyanız  ''C:\\Users\\Public/BankaKullanıcıları.txt''  Konumuna Başarıyla Kaydedildi");
                    AnaMenü();

                    break;

                case 4:
                    NedenBiz bilgiEkranı = new NedenBiz();
                    bilgiEkranı.Acıklama();

                    break;

                default:
                    System.out.println("Hatalı Giriş Yapıldı Lütfen Kontrol Ediniz.\n");
                    AnaMenü();
                    break;
            }
        }
    }
    
    //Kullanıcı menü methodum
    public static void KullanıcıMenu() {
        System.out.println("\n*********TurkDonmez Bank'a Hoşgeldiniz SAYIN  " + isim[KullanıcıSayacı - 1].toUpperCase() + "  "
                + Soyisim[KullanıcıSayacı - 1].toUpperCase() + " *********");
        System.out.println("Hesap Numaranız :  " + HesapNumarası[KullanıcıSayacı - 1] + "  //  " + "Bakiyeniz :  " + bakiyeGöster.döndür()
                + "  //  " + "Sisteme Kayıt Tarihiniz : " + KayıtTarihi[KullanıcıSayacı - 1] + "  //  " + KullanıcıSayacı + ". Müşterimizsiniz");
        System.out.println(" \n---Lütfen Yapmak İstediğiniz İşlemi Seçiniz---");
        System.out.println("      1---->  Hesabıma Para Yatır <------1");
        System.out.println("      2---->  Hesabımdan Para Çek  <------2");
        System.out.println("       3---->  Bakiye Sorgulama  <------3");
        System.out.println("       4----> Hesabımdan Çıkış Yap<------4");
        System.out.println("Seçiminiz : ");
        secim2 = tercih2.nextInt();

        switch (secim2) {
            case 1:
                HesabaParaYatır paraYatır = new HesabaParaYatır();
                paraYatır.ParaYatırmaEkranı();
                break;
            case 2:
                HesaptanParaÇek paraCek = new HesaptanParaÇek();
                paraCek.ParaCekmeEkranı();
                break;
            case 3:
                HesabaParaYatır bakiyeGöster = new HesabaParaYatır();
                bakiyeGöster.YeniBakiyeGöstermeEkranı2();
                break;
            case 4:
                AnaMenü();
                break;
            default:
                System.out.println("Hatalı Giriş Yaptınız");

        }
    }

    //Kaydolma methodum
    public static void Kaydol() {

        System.out.println("İsminizi Giriniz : ");
        isim[KullanıcıSayacı] = BilgiAlici.nextLine();

        System.out.println("Soyisminizi Giriniz : ");
        Soyisim[KullanıcıSayacı] = BilgiAlici.nextLine();

        System.out.println("Dogum Yılınızı Giriniz : ");
        DogumYılı[KullanıcıSayacı] = SifreAlici.nextInt();

        System.out.println("Bir Şifre Belirleyin : ");
        Sifre[KullanıcıSayacı] = BilgiAlici.nextLine();

        HesapNumarası[KullanıcıSayacı] = random();
        Yas[KullanıcıSayacı] = 2019 - DogumYılı[KullanıcıSayacı];
        KayıtTarihi[KullanıcıSayacı] = Tarih();
        Bakiye[KullanıcıSayacı] = 0;

    }
    
    //Müşterileri listeleme methodum
    public static void Listele() {

        for (int j = 0; j < KullanıcıSayacı; j++) {
            System.out.println("\n" + (j + 1) + ".  Müşteri İsim Soyisim :  " + isim[j].toUpperCase() + "  " + Soyisim[j].toUpperCase() + "    "
                    + " Hesap Numarası :  " + HesapNumarası[j].toString() + "    Yas :  " + Yas[j] + "    Bankaya Kayıt Tarihi :  " + KayıtTarihi[j]);
        }
        System.out.println("****************************************************LİSTE SONU*************************************************************");
    }

    //Müşterileri txt kaydetme methodum
    public static void textKaydet() {
        for (int k = 0; k < KullanıcıSayacı; k++) {
            File dosya = new File("C:\\Users\\Public/BankaKullanıcıları.txt");
            try {
                FileWriter kaydedici = new FileWriter(dosya, true);
                BufferedWriter writer = new BufferedWriter(kaydedici);
                writer.write((k + 1) + ". Müşteri Hesap Bilgileri :");
                writer.newLine();
                writer.newLine();
                writer.write("Müşteri İsm Soyisim :  " + isim[k] + "  " + Soyisim[k]);
                writer.newLine();
                writer.write("Hesap Numarası :  " + HesapNumarası[k] + "  ");
                writer.newLine();
                writer.write("Yas :  " + Yas[k] + "  ");
                writer.newLine();
                writer.write("Bankaya Kayıt Tarihi :  " + KayıtTarihi[k] + "  ");
                writer.newLine();
                writer.newLine();
                writer.newLine();

                writer.close();
                kaydedici.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    
    //Sisteme kayıt tarihi
    public static String Tarih() {
        Date simdikiZaman = new Date();

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        KayıtTarihi[KullanıcıSayacı] = df.format(simdikiZaman);
        return KayıtTarihi[KullanıcıSayacı];
    }
    
    //Rastgele hesap Numarası verme methodum
    public static String random() {
        Random rastgele = new Random();

        double a;
        a = rastgele.nextDouble();
        String number = Integer.toString((int) (a * 1000000000));
        return number;
    }
   
    //Müşteri sayısını arttırma methodum
    public static int SayacıArtırma() {
        KullanıcıSayacı++;
        return KullanıcıSayacı;
    }

}
