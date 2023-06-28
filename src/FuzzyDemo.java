public class FuzzyDemo {
    public static void main(String[] args) {
        
        Fuzzy fuzzy = new Fuzzy();
        double ipk = 3, gaji = 2.8;

        // Tahap fuzzifikasi
        double ipkJelek = fuzzy.leftTrapesium(ipk, 0, 2, 2.8);
        double ipkSedang = fuzzy.triangle(ipk,  2, 2.8, 3.2);
        double ipkBagus = fuzzy.rightTrapesium(ipk, 2.8, 3.2, 4 );
        
        System.out.println("\nFuzzifikasi ipk");
        System.out.println("Ipk Jelek\t: "+ipkJelek);
        System.out.println("Ipk Sedang\t: "+ipkSedang);
        System.out.println("Ipk Bagus\t: "+ipkBagus);

        double gajiRendah = fuzzy.leftTrapesium(gaji, 0, 2.5, 5);
        double gajiCukup = fuzzy.triangle(gaji, 2.5, 5, 8);
        double gajiTinggi = fuzzy.rightTrapesium(gaji, 5, 8, 12);
        
        System.out.println("\nFuzzifikasi gaji");
        System.out.println("gaji Rendah\t: "+gajiRendah);
        System.out.println("gaji Cukup\t: "+gajiCukup);
        System.out.println("gaji Tinggi\t: "+gajiTinggi);

        // Tahap inferensi
        fuzzy.inferensi(ipkJelek, gajiRendah, "kurang");
        fuzzy.inferensi(ipkJelek, gajiCukup, "kurang");
        fuzzy.inferensi(ipkJelek, gajiTinggi, "kurang");
        fuzzy.inferensi(ipkSedang, gajiRendah, "lumayan");
        fuzzy.inferensi(ipkSedang, gajiCukup, "kurang");
        fuzzy.inferensi(ipkSedang, gajiTinggi, "kurang");
        fuzzy.inferensi(ipkBagus, gajiRendah, "layak");
        fuzzy.inferensi(ipkBagus, gajiCukup, "lumayan");
        fuzzy.inferensi(ipkBagus, gajiTinggi, "lumayan");

        System.out.println("\nHasil inferensi");
        System.out.println("Kurang\t\t:" + fuzzy.kurang);
        System.out.println("Lumayan\t\t:" + fuzzy.lumayan);
        System.out.println("Layak\t\t:" + fuzzy.layak);

        // Tahap defuzifikasi
        fuzzy.sample(0, 50, 80, 100);
        double result = fuzzy.defuzzification();

        System.out.println("\nDidapatkan");
        System.out.println("Kelayakan\t: "+result);
        
    }
}
