package turkdonmez.bank;

public class TurkDonmezBank extends Hesap {

    static Hesap hersey = new Hesap();

    public static void main(String[] args) {
      
        //Bütün işlemleri çağıran main methodum
        AnaMenü();
        if (secim1 == 5) {
            System.out.println("Bizi Tercih Ettiğiniz İçin Teşekkür Ederiz. ***HoşçaKalın***");
        }
    }

}
