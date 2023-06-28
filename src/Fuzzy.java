public class Fuzzy {

    public double kurang, lumayan, layak;
    public double sample1, sample2, sample3;


    public double triangle(double x, double a, double b, double c) {
        if (x == b) return 1;
        if (x >= a && x <= b) return (x - a) / (b - a);
        if (x >= b && x <= c) return (c - x) / (c - b);
        return 0;
    }

    public double leftTrapesium(double x, double b, double c, double d) {
        if (x >= b && x <= c) return 1;
        if (x > c && x <= d) return (d - x) / (d - c);
        return 0;
    }

    public double rightTrapesium(double x, double a, double b, double c) {
        if (x >= b && x <= c) return 1;
        if (x >= a && x < b) return (x - a) / (b - a);

        return 0;
    }

    public void inferensi(double ipk, double gaji, String kelayakan) {
        double last = Math.min(ipk, gaji);
        if (kelayakan == "kurang") {
            if (last >= kurang) kurang = last;
        } else if (kelayakan == "lumayan") {
            if (last >= lumayan) lumayan = last;
        } else if (kelayakan == "layak") {
            if (last >= layak) layak = last;
        }
    }

    public void sample(double a, double b, double c, double d) {
        sample1 = (a + b)/2;
        sample2 = (b + c)/2;
        sample3 = (c + d)/2;
    }

    // mamdani
    public double defuzzification() {
        double result = (kurang * sample1) + (lumayan * sample2) + (layak * sample3);
        return result/(kurang + lumayan + layak) ;
    }
}

    // public void inferensi(double ipk, double gaji, String kelayakan) {
    //     if (kelayakan == "kurang") {
    //         Double tempKurang = Math.min(ipk, gaji);
    //         if (kurang == 0) kurang = tempKurang;
    //         if (kurang != 0 && tempKurang > kurang) kurang = tempKurang;

    //     } else if (kelayakan == "lumayan") {
    //         Double tempLumayan = Math.min(ipk, gaji);
    //         if (lumayan == 0) lumayan = tempLumayan;
    //         if (lumayan != 0 && tempLumayan > lumayan) lumayan = tempLumayan;

    //     } else if (kelayakan == "layak") {

    //         Double tempKurang = Math.min(ipk, gaji);
    //         if (kurang == 0) kurang = tempKurang;
    //         if (kurang != 0 && tempKurang > kurang) kurang = tempKurang;
    //     }
    // }
